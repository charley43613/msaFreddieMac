package com.fm.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fm.model.ImgCompObj;
import com.fm.model.MsgStack;
//http://localhost:4200
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/awsImg")
public class ImgCompareController {
	

	
	@PostMapping("/doit")
	public MsgStack compareImages(@RequestBody ImgCompObj imgUrls) {
		
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
