package com.codeo.shop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeo.shop.Dao.MyOrderDao;

@WebServlet("/StatusServlet")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   MyOrderDao mod=new MyOrderDao();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("Action");
		 switch(action) {
			case "ApproveOrder":
				approveOrder(request, response);
				break;
			case "RejectOrder":
				rejectdOrder(request, response);
				break;	
			default:
				break;
			} 
	}
	
	private void approveOrder(HttpServletRequest request, HttpServletResponse response) {
		String O_Id=request.getParameter("O_Id");
		if(O_Id!=null) {
			try {
				mod.approvedOrder(O_Id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void rejectdOrder(HttpServletRequest request, HttpServletResponse response) {
		String O_Id=request.getParameter("O_Id");
		if(O_Id!=null) {
			try {
				mod.rejectdOrder(O_Id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
