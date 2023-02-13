package com.codeo.shop.entity;

public class Cart extends Product {

	private int quantity;
	 private int calculated_price;
	 
	public Cart() {}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	 public void setcalculated_price(int calculated_price) {
	        this.calculated_price = calculated_price;
	    }

	    public int getCalculated_price() {
	        return calculated_price;
	       }
	    
	   
	    
	    }
