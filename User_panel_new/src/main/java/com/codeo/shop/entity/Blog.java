package com.codeo.shop.entity;

public class Blog {
	private int b_id;
	private String blog_name;
	private String blog_description;
	private String blog_title;

	public Blog(int b_id, String blog_name, String blog_description, String blog_title) {
		super();
		this.b_id = b_id;
		this.blog_name = blog_name;
		this.blog_description = blog_description;
		this.blog_title = blog_title;
	}

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getBlog_name() {
		return blog_name;
	}

	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}

	public String getBlog_description() {
		return blog_description;
	}

	public void setBlog_description(String blog_description) {
		this.blog_description = blog_description;
	}
	
	
	

	

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	@Override
	public String toString() {
		return "Blog [b_id=" + b_id + ", blog_name=" + blog_name + ", blog_description=" + blog_description
				+ ", blog_title=" + blog_title + "]";
	}

	
	
	
	

}
