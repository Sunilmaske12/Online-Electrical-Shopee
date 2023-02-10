package com.codeo.shop.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	
	
	private static final String DriverClassName ="com.mysql.cj.jdbc.Driver" ;
	private static final String jdbcUrl ="jdbc:mysql://localhost:3306/oes";
	static private final String user_name="root";
	static private final String password="";
	static Connection con = null;
	
	public static  Connection getconnection()
	{
	
		try {
			Class.forName(DriverClassName);
			
			con = DriverManager.getConnection(jdbcUrl, user_name, password);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	
		return con;
	}
	
	
}
