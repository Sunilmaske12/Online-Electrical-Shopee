package com.codeo.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeo.shop.Dao.CustomerDao;
import com.codeo.shop.entity.Customer;

@WebServlet("/SaveAddress")

public class Customer_Address_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 String custo_id = null;    
 String custo_name= null;
 String custo_mobno = null;
 String custo_adderess = null;
 String custo_email = null;
 String custo_landmark = null;
 String custo_AddressType = null;
 String custo_city = null;
 String custo_pincode = null;
 String u_id = null;
 PrintWriter pw = null;
 RequestDispatcher dispatcher = null;
 Customer customer = null;
 CustomerDao custoDAO = null;
 
	
   public void init()
	{ 
		custoDAO = new CustomerDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		u_id=request.getParameter("user_id");
		System.out.print(u_id);
		  custo_name = request.getParameter("name");
		  System.out.print("name:  =="+custo_name);
			 custo_mobno = request.getParameter("mobile");

		  System.out.print("num:  =="+custo_mobno);
		  custo_adderess = request.getParameter("address");
		  System.out.print("address:  =="+custo_adderess);
		  custo_email = request.getParameter("email");
		  System.out.print("email:  =="+custo_email);
		
		 
		 custo_landmark = request.getParameter("landmark");
		 custo_AddressType = request.getParameter("addresstype");
		 custo_city = request.getParameter("city");
		 custo_pincode = request.getParameter("pincode");
		
		 
		 
		 customer = new Customer(custo_id, custo_name, custo_mobno, custo_adderess, custo_email, custo_landmark, custo_AddressType, custo_city, custo_pincode, u_id);	
		
		
		 
			if(u_id!=null)
			{
				
				custoDAO.insertCustoDetail(customer);
					response.sendRedirect("checkout.jsp");
					System.out.print("u_id is not empty");
				} } 
		

	

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
		
		if(custoDAO.deleteUser(id))
		{
			try {
				response.sendRedirect("UserList.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			} } }
	
	private void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			  dispatcher = request.getRequestDispatcher("Edit.jsp");
	  dispatcher.forward(request, response);
	
	}
	}