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
import com.fm.utils.AwsFaceComparor;
import com.fm.utils.ImgUrlConverter;




		
@CrossOrigin(origins = {"*"}, allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/awsImg")
public class ImgCompareController {
	

	
	@PostMapping("/doit")
	public MsgStack compareImages(@RequestBody ImgCompObj imgUrls) {
		String imgAtoB = null;
		String imgAtoC = null;
		MsgStack msgStack= new MsgStack();
		ArrayList<InputStream> al = new ArrayList<>();
		try {
			msgStack.setImgAtoB(AwsFaceComparor.compareImgInputStreams(ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg1()), ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg2())));
			msgStack.setImgAtoC(AwsFaceComparor.compareImgInputStreams(ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg1()), ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg3())));

			
			//			InputStream isImg1 = ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg1());
//			InputStream isImg2 =  ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg2());
//			InputStream isImg3 =  ImgUrlConverter.getInputStreamOfImage(imgUrls.getImg3());
//			al.add(isImg1);
//			al.add(isImg2);
//			al.add(isImg3);
//			for(InputStream a: al) {
//				System.out.println(a.toString());
//
//			}

			msgStack.setSuccess(true);
			System.out.println(msgStack.getImgAtoB());
			System.out.println(msgStack.getImgAtoC());
			System.out.println(msgStack.isSuccess());
//			if(msgStack.getImgAtoB().equals("applesauce")) {
//				throw new MalformedURLException();
//			}
			return msgStack;

		}
			
			catch	(MalformedURLException e) {
				e.printStackTrace();
				msgStack.setSuccess(false);
				System.out.println(msgStack.toString());
				return msgStack;
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msgStack.setSuccess(false);
				return msgStack;
			}
			catch(Exception e) {
				e.printStackTrace();
				msgStack.setSuccess(false);
				return msgStack;
			}	
		

	}
	
	@GetMapping("/**")
	public String handleGet() throws Exception {
		return ("Carole Baskin");

    }
	

	
}
