package com.fm.controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.BoundingBox;
import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;
import com.amazonaws.services.rekognition.model.ComparedFace;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.util.IOUtils;
import com.fm.model.ImgCompObj;
import com.fm.model.MsgStack;
import com.fm.utils.ImgUrlConverter;
//http://localhost:4200
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/awsImg")
public class ImgCompareController {
	

	
	@PostMapping("/doit")
	public MsgStack compareImages(@RequestBody ImgCompObj imgUrls) {

		ArrayList<InputStream> al = new ArrayList<>();
		try {
			InputStream isImg1 = ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg1());
			InputStream isImg2 =  ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg2());
			InputStream isImg3 =  ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg3());
			al.add(isImg1);
			al.add(isImg2);
			al.add(isImg3);
			for(InputStream a: al) {
				System.out.println(a.toString());

			}
			
		       Float similarityThreshold = 70F;
		       ByteBuffer sourceImageBytes=null;
		       ByteBuffer targetImageBytes=null;

		       AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();

		       //Load source and target images and create input parameters
		       try (InputStream inputStream = isImg1) {
		          sourceImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
		       }
		       catch(Exception e)
		       {
		           System.out.println("Failed to load source image " + imgUrls.getImg1());
		           return(null);
		       }
		       try (InputStream inputStream = isImg2) {
		           targetImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
		       }
		       catch(Exception e)
		       {
		           System.out.println("Failed to load target images: " + imgUrls.getImg2());
		           return(null);
		       }

		       Image source=new Image()
		            .withBytes(sourceImageBytes);
		       Image target=new Image()
		            .withBytes(targetImageBytes);

		       CompareFacesRequest request = new CompareFacesRequest()
		               .withSourceImage(source)
		               .withTargetImage(target)
		               .withSimilarityThreshold(similarityThreshold);

		       // Call operation
		       CompareFacesResult compareFacesResult=rekognitionClient.compareFaces(request);


		       // Display results
		       List <CompareFacesMatch> faceDetails = compareFacesResult.getFaceMatches();
		       for (CompareFacesMatch match: faceDetails){
		         ComparedFace face= match.getFace();
		         BoundingBox position = face.getBoundingBox();
		         System.out.println("Face at " + position.getLeft().toString()
		               + " " + position.getTop()
		               + " matches with " + face.getConfidence().toString()
		               + "% confidence.");

		       }
		       List<ComparedFace> uncompared = compareFacesResult.getUnmatchedFaces();

		       System.out.println("There was " + uncompared.size()
		            + " face(s) that did not match");
		       System.out.println("Source image rotation: " + compareFacesResult.getSourceImageOrientationCorrection());
		       System.out.println("target image rotation: " + compareFacesResult.getTargetImageOrientationCorrection());
			
			
			
			
			
			
			
			
			
			
			
		}
		catch	(MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		MsgStack msgStack= new MsgStack(imgUrls.getImg1(), imgUrls.getImg2(), true);
		return msgStack;
//	    return ResponseEntity
//				.status(401)
//				.body("JWT token value invalid");//return the payload for client to utilize the userId for the session
//
//		
		

	}
	
	@GetMapping("/doit")
	public String handleGet() throws Exception {
		return ("Carole Baskin");

    }
	

	
}
