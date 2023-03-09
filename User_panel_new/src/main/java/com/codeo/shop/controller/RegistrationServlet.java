package com.codeo.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeo.shop.Dao.UserDAO;
import com.codeo.shop.Dao.UserDaoImpl;
import com.codeo.shop.entity.User;

@WebServlet("/Registration")

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
 String user_name= null;
 String user_mobno = null;
 String user_adderess = null;
 String user_emailid = null;
 String user_pass = null;
 PrintWriter pw = null;
 RequestDispatcher dispatcher = null;
 User user = null;
 UserDAO userDAO = null;
 String user_type = null;
	
   public void init()
	{ 
		userDAO = new UserDaoImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 user_name = request.getParameter("name");
		 user_mobno = request.getParameter("contact");
		 user_adderess = request.getParameter("Address");
		 user_emailid = request.getParameter("email");
		 user_pass = request.getParameter("pass");
		 user_type = request.getParameter("user_type");
		 user = new User(user_name, user_mobno, user_adderess, user_emailid,user_pass,user_type);	
		 System.out.println(user_name+" "+user_mobno+" "+user_type);
		
		 
		
				if(userDAO.insertUser(user)) {
					
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("message", "Registration Successful       ");
					response.sendRedirect("loginfrom.jsp");
					
					
					
					
		              }
				else {
					response.sendRedirect("RegistrationForm.jsp");

				}
			} 
		

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   String action = request.getParameter("action");
		
          switch(action) {
			
			case "EDIT":
				getSingleUser(request, response);
				break;
				
			case "DELETE":
				deleteUser(request, response);
				break;
			
			default:
				listProduct(request, response);
				break;
			} }

	private void listProduct(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(userDAO.deleteUser(id))
		{
			try {
				response.sendRedirect("UserList.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			} } }
	
	private void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//User useredit = new User();
	    //useredit =userDAO.edituser(id);
		
	  //request.setAttribute("user", useredit);
	  dispatcher = request.getRequestDispatcher("Edit.jsp");
	  dispatcher.forward(request, response);
	
	}
	}