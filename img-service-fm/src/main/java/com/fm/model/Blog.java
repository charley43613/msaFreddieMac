package com.fm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//where value=class name by default or set value after @documetn annotation
@Document
public class Blog {
	@Id
	private String id;
	private String author;
	private String timeago;
	private String commentText;
	public Blog(String author, String timeago, String commentText) {
		super();
		this.author = author;
		this.timeago = timeago;
		this.commentText = commentText;
	}
	public String getId() {
		return id;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTimeago() {
		return timeago;
	}
	public void setTimeago(String timeago) {
		this.timeago = timeago;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}



}
