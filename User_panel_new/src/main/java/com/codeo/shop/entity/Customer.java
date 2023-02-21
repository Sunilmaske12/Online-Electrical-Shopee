package com.codeo.shop.entity;

public class Customer {
	String c_id = null;    
	 String c_name= null;
	 String c_mobno = null;
	 String c_adderess = null;
	 String c_email = null;
	 String c_landmark = null;
	 String c_AddressType = null;
	 String c_city = null;
	 String c_pincode = null;
	 String u_id = null;
	 public Customer(String c_id, String c_name, String c_mobno, String c_adderess, String c_email, String c_landmark,
			String c_AddressType, String c_city, String c_pincode, String u_id) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_mobno = c_mobno;
		this.c_adderess = c_adderess;
		this.c_email = c_email;
		this.c_landmark = c_landmark;
		this.c_AddressType = c_AddressType;
		this.c_city = c_city;
		this.c_pincode = c_pincode;
		this.u_id = u_id;
	}
	public Customer() {
		
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_mobno() {
		return c_mobno;
	}
	public void setC_mobno(String c_mobno) {
		this.c_mobno = c_mobno;
	}
	public String getC_adderess() {
		return c_adderess;
	}
	public void setC_adderess(String c_adderess) {
		this.c_adderess = c_adderess;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	public String getC_landmark() {
		return c_landmark;
	}
	public void setC_landmark(String c_landmark) {
		this.c_landmark = c_landmark;
	}
	public String getC_AddressType() {
		return c_AddressType;
	}
	public void setC_AddressType(String c_AddressType) {
		this.c_AddressType = c_AddressType;
	}
	public String getC_city() {
		return c_city;
	}
	public void setC_city(String c_city) {
		this.c_city = c_city;
	}
	public String getC_pincode() {
		return c_pincode;
	}
	public void setC_pincode(String c_pincode) {
		this.c_pincode = c_pincode;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", c_mobno=" + c_mobno + ", c_adderess=" + c_adderess
				+ ", c_email=" + c_email + ", c_landmark=" + c_landmark + ", c_AddressType=" + c_AddressType
				+ ", c_city=" + c_city + ", c_pincode=" + c_pincode + ", u_id=" + u_id + "]";
	}
	
	 

	

}