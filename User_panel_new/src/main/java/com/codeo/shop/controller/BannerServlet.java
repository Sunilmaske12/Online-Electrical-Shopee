package com.codeo.shop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.codeo.shop.Dao.BannerDao;
import com.codeo.shop.entity.Banner;

@MultipartConfig
@WebServlet("/BannerOperation")
public class BannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int banner_no;
	String banner_name;
	String action;
	String Banner_image;
	RequestDispatcher dispatcher = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		banner_name=request.getParameter("b_name");
		action=request.getParameter("Action");
		Part file=request.getPart("b_image");
		Banner_image=file.getSubmittedFileName();
	 String path = request.getServletContext().getRealPath("img")+File.separator+"banner"+File.separator+file.getSubmittedFileName(); 
	 //System.out.print(path);
	 //file writing uploading banner to folder
	 FileOutputStream fos=new FileOutputStream(path);
	 InputStream fis= file.getInputStream();
	 byte[] data = new byte[fis.available()] ;
     fis.read(data);
	fos.write(data);
	fos.close();
	fis.close();
	Banner banner=new Banner(banner_name, action, Banner_image);
	if(BannerDao.addBanner(banner)) {
		System.out.print("Banner is inserted");
		dispatcher = request.getRequestDispatcher("Banner.jsp");
		dispatcher.forward(request, response);
	}
	} 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String action=request.getParameter("action");
	
	switch(action) {
	case "EDIT":editBanner(request, response);
			break;
	case "DELETE":deleteBanner(request, response);
	break;
	default:
	break;
	}
		
	}

	private void editBanner(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id=Integer.parseInt(request.getParameter("banner_id"));
			String B_Image=request.getParameter("b_image");
			String b_name=request.getParameter("b_name");
		if(BannerDao.edit(id,b_name, B_Image))
		{
			dispatcher = request.getRequestDispatcher("Banner.jsp");
			dispatcher.forward(request, response);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void deleteBanner(HttpServletRequest request, HttpServletResponse response) {
		try {
			
		int id=Integer.parseInt(request.getParameter("id"));
		if(BannerDao.delete(id))
		{
			dispatcher = request.getRequestDispatcher("Banner.jsp");
			dispatcher.forward(request, response);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}



