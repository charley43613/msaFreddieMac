package com.fm.controllers;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

		ArrayList<String> al = new ArrayList<>();
		try {
			String base64img1 = ImgUrlConverter.getBase64EncodedImage(imgUrls.getImg1());
			String base64img2 =  ImgUrlConverter.getBase64EncodedImage(imgUrls.getImg2());
			String base64img3 =  ImgUrlConverter.getBase64EncodedImage(imgUrls.getImg3());
			al.add(base64img1);
			al.add(base64img2);
			al.add(base64img3);
			for(String a: al) {
				System.out.println(a.substring(20, 35));

			}
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
	public String handleGet() {
		return "Hello Cindy!";
	}
	

	
}
