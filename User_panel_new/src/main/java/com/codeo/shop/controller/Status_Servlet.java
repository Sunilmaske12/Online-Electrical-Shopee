package com.codeo.shop.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codeo.shop.Dao.MyOrderDao;

@WebServlet("/Status_Servlet")
@MultipartConfig
public class Status_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Order_id = request.getParameter("O_Id");
		

		MyOrderDao mod = new MyOrderDao();
		try {
			if (mod.approvedOrder(Order_id)) {
				dispatcher = request.getRequestDispatcher("ViewOrderAdmin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("Action");
		
		switch (action) {
		case "approve":
			 approvedOrder(request, response);
			break;

		case "reject":
			 rejectOrder(request, response);
			break;
		default:
			 approvedOrder(request, response);
			break;
		}
		
	}

	private void approvedOrder(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String Order_id = request.getParameter("O_Id");
		MyOrderDao mod = new MyOrderDao();
	
		try {
			if (mod.approvedOrder(Order_id)) {
				dispatcher = request.getRequestDispatcher("ViewOrderAdmin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void rejectOrder(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String Order_id = request.getParameter("O_Id");
		MyOrderDao mod = new MyOrderDao();
	
		try {
			if (mod.rejectOrder(Order_id)) {
				dispatcher = request.getRequestDispatcher("ViewOrderAdmin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
