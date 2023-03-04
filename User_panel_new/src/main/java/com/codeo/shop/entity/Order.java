package com.codeo.shop.entity;

import java.sql.Date;
public class Order {
	int orderId;
	Date Date;
	String addressId;
	String userId;
	int productId;
	String productName;
	int productPrice;
	int productQuantity;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", Date=" + Date + ", addressId=" + addressId + ", userId=" + userId
				+ ", productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + "]";
	}
	public Order(int orderId, Date date, String addressId, String userId) {
		super();
		this.orderId = orderId;
		Date = date;
		this.addressId = addressId;
		this.userId = userId;
	}
	
	public Order(int orderId, java.sql.Date date, String addressId, String userId, int productId, String productName,
			int productPrice, int productQuantity) {
		super();
		this.orderId = orderId;
		Date = date;
		this.addressId = addressId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
