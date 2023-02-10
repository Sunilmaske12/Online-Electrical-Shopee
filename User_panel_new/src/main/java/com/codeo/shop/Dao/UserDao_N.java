package com.codeo.shop.Dao;

import javax.servlet.http.HttpServlet;

import com.codeo.shop.entity.User;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;


public class UserDao_N  {
	
	private SessionFactory factory;
	 
    public UserDao_N(SessionFactory factory) {
     this.factory = factory;
      
    }

	//get user by email and password
    public User getUserByEmail_Password(String email, String password) {
    	User user=null;
    	try {
    		
    		String query="select * from User where user_emailid =: e and user_pass=:p";
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
		return user;
    	
    }
	

}
