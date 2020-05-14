package com.fm.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;


@Component
public class ImgUrlConverter {
	
	public static InputStream getInputStreamOfImage(String imageURL) throws IOException, MalformedURLException{
	    try {
	    	for(int i = 0; i<10; i++) {
	    		System.out.println(imageURL);
	    	}
			URLConnection url = new java.net.URL(imageURL).openConnection(); 
		    url.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

		    InputStream is = url.getInputStream();  
		    return is;
	    	
	    }
	    catch(MalformedURLException e) {
	    	e.printStackTrace();
	    	return null;
	    }
	    

	}

}
