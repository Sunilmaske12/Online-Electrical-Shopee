package com.codeo.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeo.shop.Dao.Contact_QueryDao;
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   public ChatServlet() {
        super();
    }
   
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
          doGet(request, response);	
	}
   	
   	
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("Action");
		
		switch (action) {
		case "chatByUser":
			 sendChatByUser(request, response);
			break;
		case "chatByAdmin":
			 sendChatByAdmin(request, response);
			break;
			default: 
				 createTicket(request, response);
			break;
		}
		
	}

	

	private void sendChatByUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String ticketId=request.getParameter("ticketId");
		String chat=request.getParameter("message");
		HttpSession session=request.getSession();
		String userName=(String) session.getAttribute("UserName");
		Contact_QueryDao cqd=new Contact_QueryDao();
		if(cqd.chatSendToAmdin(ticketId, userName, chat)) {
			response.sendRedirect("Chat.jsp?ticketId="+ticketId);
			 
		}
		
	}
	
	private void sendChatByAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String ticketId=request.getParameter("ticketId");
		String chat=request.getParameter("message");
		HttpSession session=request.getSession();
		String AdminName=(String) session.getAttribute("UserName");
		Contact_QueryDao cqd=new Contact_QueryDao();
		if(cqd.chatSendToUser(ticketId, AdminName, chat)) {
			response.sendRedirect("AdminChat.jsp?ticketId="+ticketId);
			  
		}
		
	}
	
	
	private void createTicket(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 String userId=request.getParameter("uid");
         String UserName=request.getParameter("uname");
         String message=request.getParameter("message");
           Contact_QueryDao cqd=new Contact_QueryDao();
         if(cqd.ticketGenerate(userId, UserName)) {
       	String ticketId=cqd.getTicketId();
       	if(ticketId!=null) {
       		if(cqd.chatSendToAmdin(ticketId,  UserName, message)) {
       			response.sendRedirect("contact.jsp");
       		}
       	}
       	  
         }
		
	}

}
