package com.fm;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fm.model.Blog;
import com.fm.repos.BlogRepo;

@SpringBootApplication
public class MainDriver implements CommandLineRunner{
	@Autowired
	BlogRepo blogRepo;

	public static void main(String[] args) {

		System.out.println("Version of Java used: " + getVersion());
		SpringApplication.run(MainDriver.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Blog> listOfBlogs= new ArrayList<Blog>();
		// TODO Auto-generated method stub
		Blog e1 = new Blog("Sam", "Today at 4:45PM", "Rainbows and butterflys");
		Blog e2 = new Blog("Alex", "Today at 5:30PM", "How is everyone?");
		Blog e3 = new Blog("Eric","Today at6:58PM","Staying very busy!");
		
		listOfBlogs.add(e1);
		listOfBlogs.add(e2);
		listOfBlogs.add(e3);
		blogRepo.insert(listOfBlogs);

		
		
	}
	private static int getVersion() {
	    String version = System.getProperty("java.version");
	    if(version.startsWith("1.")) {
	        version = version.substring(2, 3);
	    } else {
	        int dot = version.indexOf(".");
	        if(dot != -1) { version = version.substring(0, dot); }
	    } return Integer.parseInt(version);
	}

}
