package com.codeo.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/cartlength")
public class CartLenght extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CartLenght() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getParameter("cartlegth");
		String T_Amount=request.getParameter("TotalAmount");
		HttpSession session=request.getSession();
		session.setAttribute("cart",s );
		session.setAttribute("TotalAmount",T_Amount );
		response.sendRedirect("checkout.jsp");
		
	
	}

	
}
