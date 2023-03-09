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
	String Address=null;
	String page=null;
	RequestDispatcher dispatcher = null;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=Integer.parseInt(request.getParameter("id"));
		 name= request.getParameter("name");
		 MoNO= request.getParameter("Mobile");
		 Address= request.getParameter("address");
		page=request.getParameter("page");
		 UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.UpdateUserInfo(id, name, MoNO, Address);
		if(page.equals("Admin")) {
			dispatcher = request.getRequestDispatcher("dashbord.jsp");
			dispatcher.forward(request, response);
		}else {
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
	
	
	}
	
	
}
