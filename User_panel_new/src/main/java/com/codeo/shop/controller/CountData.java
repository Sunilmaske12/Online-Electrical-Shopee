package com.codeo.shop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeo.shop.Dao.UserDaoImpl;

public class CountData extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 try {
		Map<String, Long> m=UserDaoImpl.total_user();
		String UserCount=String.valueOf(m.get("Total_User"));
		
		HttpSession session=request.getSession();
		session.setAttribute("TotalUser", UserCount);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}



}
