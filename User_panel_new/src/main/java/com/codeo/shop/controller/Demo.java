package com.codeo.shop.controller;

import java.io.IOException;
import java.rmi.server.ObjID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.razorpay.*;

@WebServlet("/Payment")
public class Demo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String amount=	request.getParameter("amount");
	if(amount!=null) {
		int payment=100*Integer.parseInt(amount);
		System.out.println(payment);
		try {
			RazorpayClient client=new RazorpayClient("rzp_test_7TxMC9UB8XmbM0", "r6r09iYcHJk4WkPxByNFhHkn");
			JSONObject obj=new JSONObject();
			obj.put("amount", payment);
			obj.put("currency", "INR");
			obj.put("receipt", "txn_1234");
			
			//creating order
			Order order=client.orders.create(obj);
			System.out.println(order);	
			//String detail = order.toString();
			String o_id=order.get("id");
			System.out.println(o_id);	
			
		HttpSession s=request.getSession();
		s.setAttribute("o_id", o_id);
			
			
			
			
			
		} catch (RazorpayException e) {
			e.printStackTrace();
		}
	}
	
	response.sendRedirect("demo.jsp");
}
}