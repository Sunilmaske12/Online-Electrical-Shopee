package com.codeo.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeo.shop.Dao.CategoryDao;
import com.codeo.shop.entity.Category;

@WebServlet("/Addcategory")

public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	PrintWriter pw = null;
	String Cat_title = null;
	String cat_description =null;
	CategoryDao cd = null;
	Category  category = null;
	int Id= 0;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			pw = response.getWriter();
	    	Cat_title = request.getParameter("cattitle");
			 cat_description = request.getParameter("catdesc");
	       
			 // Id = Integer.parseInt(request.getParameter("id"));
			 // System.out.println("id :"+ Id);
			  System.out.println(Cat_title);
			  // category = new Category(Id,Cat_title,cat_description);
			  
			   category = new Category(Cat_title,cat_description);
				  
			   cd = new CategoryDao();
				 boolean flag = false;
				
				flag = cd.addcategory(category);
				System.out.println(flag);
				
				if(flag==true)
				{
					response.sendRedirect("View_Category.jsp");
				}	
				
		doGet(request, response);
	}	
	
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			
		}

      }

	
