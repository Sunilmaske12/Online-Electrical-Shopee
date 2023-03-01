package com.codeo.shop.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeo.shop.Dao.GmailSenderDao;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		String email=(String) session.getAttribute("email");
		RequestDispatcher dispatcher = null;
		GmailSenderDao gsd=new GmailSenderDao();
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

			try {
				gsd.setNewPassword(email, newPassword);
				request.setAttribute("errorMessage","Password set succesfully, you can login now");
				dispatcher = request.getRequestDispatcher("loginfrom.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
