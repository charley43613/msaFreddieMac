package com.fm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.util.List;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.BoundingBox;
import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;
import com.amazonaws.services.rekognition.model.ComparedFace;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.util.IOUtils;

public class AwsFaceComparor {
	
	public static String compareImgInputStreams(InputStream isImg1, InputStream isImg2) throws Exception {
	       String confidenceMsg = null;
	       Float similarityThreshold = 0F;
	       ByteBuffer sourceImageBytes=null;
	       ByteBuffer targetImageBytes=null;

	       AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();

	       //Load source and target images and create input parameters
	       try (InputStream inputStream = isImg1) {
	          sourceImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
	       }
	       catch(Exception e)
	       {
	    	   e.printStackTrace();
	           System.out.println("Failed to load source image " );
	           return(confidenceMsg = "Failed to load source image");
	       }
	       try (InputStream inputStream = isImg2) {
	           targetImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
	       }
	       catch(Exception e)
	       {
	           System.out.println("Failed to load target image: " );
	           return(confidenceMsg);
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
	         confidenceMsg = " % Similarity is:" + match.getSimilarity();

	       }
	       	return confidenceMsg;
		}
	}
