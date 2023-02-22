package com.codeo.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codeo.shop.Dao.UserDaoImpl;

@WebServlet("/edit_user")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id=0;
	String name=null;
	String MoNO=null;
	String Email=null;
	String Address=null;
	RequestDispatcher dispatcher = null;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=Integer.parseInt(request.getParameter("id"));
		 name= request.getParameter("name");
		 MoNO= request.getParameter("Mobile");
		 Email= request.getParameter("email");
		 Address= request.getParameter("address");
		
		 UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.UpdateUserInfo(id, name, MoNO, Email, Address);
		
		dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	
	
	
	
	
	
	
	}
	

}
