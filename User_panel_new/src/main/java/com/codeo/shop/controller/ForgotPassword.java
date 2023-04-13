package com.codeo.shop.controller;


import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeo.shop.Dao.GmailSenderDao;

// 5 steps
// 1. configure SMTP server details using java Properties object
// 2.create session with getInstance() & pass properties & authenticator & override getPasswordAuthentication() method
// 3.create msg we can use MimeMessage class. Message class represent the message. MimeMessage is implementation class of message
// 4.Set the to, from, subject, message etc
// 5. Use Transport class to send the mail.


@WebServlet("/forgotPassword")
public class ForgotPassword extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailid = request.getParameter("email");
		RequestDispatcher dispatcher = null;
		int otpvalue = 0;
		HttpSession mySession = request.getSession();
		
		GmailSenderDao gsd=new GmailSenderDao();
		int count=0;
		try {
			  count=gsd.getUserDatailsbyEmail(emailid);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(emailid!=null && count!=0 ) {
			// sending otp
			Random rand = new Random();
			otpvalue = rand.nextInt(1255650);
			
			String to = emailid;
			String from = "sunilmaske2001@gmail.com";
			String subject="Dear User";
			String text="your OTP is: " + otpvalue;
			gsd.sendEmail(to, from, subject, text);
			
				
			mySession.setAttribute("otp",otpvalue); 
			mySession.setAttribute("email",emailid); 
			
			dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
			dispatcher.forward(request, response);
		
		}
		else {
			request.setAttribute("errorMessage","register email not found");
			
			   dispatcher=request.getRequestDispatcher("forgotPassword.jsp");
				dispatcher.forward(request, response);
		}
	}

}
