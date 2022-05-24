package com.fm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fm.model.Blog;
import com.fm.services.BlogService;

@RestController
@RequestMapping("/Blog")
@CrossOrigin(origins = { "*" }, allowedHeaders = "*", allowCredentials = "true", methods=RequestMethod.GET)

public class BlogController {
	@Autowired
	BlogService blogService;
	
	@GetMapping("/")
	public List<Blog> getAll(){
		return blogService.getAll();
	}

}
