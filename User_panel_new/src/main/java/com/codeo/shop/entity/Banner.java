package com.codeo.shop.entity;

public class Banner {
	
	
	int banner_no;
	public int getBanner_no() {
		return banner_no;
	}




	public void setBanner_no(int banner_no) {
		this.banner_no = banner_no;
	}




	public String getDate() {
		return Date;
	}




	public void setDate(String date) {
		Date = date;
	}




	String banner_name;
	String Date;
	String action;
	String Banner_image;
	
	
	

	public Banner(String banner_name, String action, String banner_image) {
		super();
		this.banner_name = banner_name;
		this.action = action;
		Banner_image = banner_image;
	}




	public Banner() {
		// TODO Auto-generated constructor stub
	}




	public String getBanner_name() {
		return banner_name;
	}




	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}




	public String getAction() {
		return action;
	}




	public void setAction(String action) {
		this.action = action;
	}




	public String getBanner_image() {
		return Banner_image;
	}




	public void setBanner_image(String banner_image) {
		Banner_image = banner_image;
	}
	
	
	

}
