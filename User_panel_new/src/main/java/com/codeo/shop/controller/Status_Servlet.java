package com.codeo.shop.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeo.shop.Dao.BannerDao;
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
		case "active":
			try {
				activeBaner(request, response);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "inactive":
			try {
				inactiveBaner(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;	
		
			default: 
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
			e.printStackTrace();
		}
	}
	
	private void activeBaner(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String b_id=request.getParameter("B_Id");
		BannerDao bd=new BannerDao();
		if(bd.activeBanner(b_id)) {
			response.sendRedirect("Banner.jsp");
		}			
	}
	
	private void inactiveBaner(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String b_id=request.getParameter("B_Id");
		BannerDao bd=new BannerDao();
		if(bd.inactiveBanner(b_id)) {
			response.sendRedirect("Banner.jsp");
		}			
	}

}
