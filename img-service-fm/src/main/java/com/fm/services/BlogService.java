package com.fm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.model.Blog;
import com.fm.repos.BlogRepo;

@Service
public class BlogService {
	@Autowired
	BlogRepo blogRepository;
	
	public List<Blog> getAll(){
		return blogRepository.findAll();
	}

}
