package com.codeo.shop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.codeo.shop.Dao.LoginDaoImpl;
import com.codeo.shop.Dao.UserDAO;
import com.codeo.shop.Dao.UserDaoImpl;
import com.codeo.shop.dbutil.ConnectionProvider;
import com.codeo.shop.entity.Login;
import com.codeo.shop.entity.User;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")

public class LoginServlet extends HttpServlet {
	
	
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String user_emailid = request.getParameter("Email");
			String user_pass = request.getParameter("password");
			String user_type = request.getParameter("user_type");
			
			try
			{
				
				/*
				Connection con = ConnectionProvider.getconnection();
				
				 PreparedStatement ps = con.prepareStatement("select * from user_registration where user_emailid=? and user_pass=?");
				 ps.setString(1,user_emailid );
		            ps.setString(2, user_pass);
		            ResultSet rs = ps.executeQuery();
		        */
				ResultSet rs = UserDaoImpl.getUserDetails(user_emailid, user_pass);
				 HttpSession session1=request.getSession();
				
				//session1.setAttribute("UserName", rs.getString("user_name"));
				//session1.setAttribute("email", rs.getString("user_emailid"));
				
		            if (rs.next()) {
		                String role = rs.getString("user_type");
		                String username = rs.getString("user_name");
		                String useremail = rs.getString("user_emailid");
		                int userId= rs.getInt("user_id");
		                session1.setAttribute("UserName", username);
		                session1.setAttribute("UserEmail", useremail);
		                session1.setAttribute("usertype", role);
		                session1.setAttribute("userid", userId);
		                if (role.equals("Admin")) {
		                    request.setAttribute("username", user_emailid);
		                    request.getRequestDispatcher("dashbord.jsp").forward(request, response);
		                } else {
		                    request.setAttribute("username", user_emailid);
		                    request.getRequestDispatcher("index.jsp").forward(request, response);
		                }
		                
		                
		            } else {
		                request.setAttribute("errorMessage", "Invalid username or password");
		                request.getRequestDispatcher("loginfrom.jsp").forward(request, response);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		                 
		            }

			}
			
		}


