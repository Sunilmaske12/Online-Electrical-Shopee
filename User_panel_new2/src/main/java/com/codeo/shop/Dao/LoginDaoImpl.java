package com.codeo.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.codeo.shop.dbutil.ConnectionProvider;
import com.codeo.shop.entity.Login;

public class LoginDaoImpl implements LoginDao{

	@Override
	public String loginCheck(Login login) {
		
  String query="select * from user_registration where user_emailid=? and user_pass=?";

    String username = login.getEmail();
    String password = login.getPassword();
    
    String uName ="";
    String uPass ="";
    String user_type="";
    
    Connection con=ConnectionProvider.getconnection(); 
	try {
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			uName = rs.getString("username ");
			uPass = rs.getString("password");
			user_type = rs.getString("user_type");
			
			if(username.equals(uName) &&password.equals(uPass) && user_type.equals("Admin"))
			{ return "Admin";
			}
		    else if(username.equals(uName) &&password.equals(uPass) && user_type.equals("User"))
		    {
		    	return "User";
		    }
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
       return "Invalid User credentials";
		
/*
		try {
			
			Connection con=ConnectionProvider.getconnection(); 
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,login.getEmail());
			ps.setString(2,login.getPassword());
			ResultSet rs=ps.executeQuery();
		if(rs.next()){
			return "true";
		}
		else{
			return "false";
		}
	} catch(Exception e){
		e.printStackTrace();
	}
	return "error";
	*/

	
	       }
	     }