package com.springBoot.jsp.OES.entity;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int order_Id;
	Date Date;
	@Column(name="C_Address_Id")
	String address_Id;
	int Amount;
	@Column(name="Shipping_Charges")
	int charges;
	String status;
	int Total_Amount;
	/*
	 * String user_Id; int product_Id; String product_Name; int product_Price; int
	 * product_Quantity;
	 */
	String seen;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getAddress_Id() {
		return address_Id;
	}
	public void setAddress_Id(String address_Id) {
		this.address_Id = address_Id;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getCharges() {
		return charges;
	}
	public void setCharges(int charges) {
		this.charges = charges;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotal_Amount() {
		return Total_Amount;
	}
	public void setTotal_Amount(int total_Amount) {
		Total_Amount = total_Amount;
	}
	public String getSeen() {
		return seen;
	}
	public void setSeen(String seen) {
		this.seen = seen;
	}
	
 
}
