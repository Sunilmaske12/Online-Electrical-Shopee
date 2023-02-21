package com.codeo.shop.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.codeo.shop.entity.Cart;
import com.codeo.shop.entity.Product;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  //prod_id, prod_name, prod_description, prod_price, prod_discount, prod_quantity, prod_imageName, cid
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      PrintWriter out = response.getWriter();
      
    	ArrayList<Cart> cartlist = new ArrayList<>();
    	
    	int id = Integer.parseInt(request.getParameter("id"));
       // System.out.println(id);
        //String prod_name=request.getParameter("prod_name");
        //System.out.println(prod_name);
        //String prod_price= request.getParameter("prod_price");
        //System.out.println(prod_price);
        //String prod_imageName= request.getParameter("prod_imageName");
        //System.out.println(prod_imageName);
        
     Cart cart = new Cart();
     cart.setId(id);
      cart.setQuantity(1);
      
     HttpSession session = request.getSession();
     ArrayList<Cart> cart_list=(ArrayList<Cart>)session.getAttribute("cart-list");
     
     if(cart_list ==null)
     {
    	 cartlist.add(cart);
    	 session.setAttribute("cart-list", cartlist);
    	 response.sendRedirect("index.jsp");
    	  }
     else
     {
    	 cartlist=cart_list;
    	 boolean exist=false;
    	
    	 for(Cart c :cart_list)
    	 {
    		 if(c.getId()==id) {
    			 exist =true;
    			 //out.println("<h3 style='color:crimson;text-align:center'>Item already exist in Cart.<a href='shoping-cart.jsp'>Go to Cart Page</a></h3>");
    			 response.sendRedirect("shoping-cart.jsp");
    		 } 
    		 }
    	 
    	  if(!exist) {
    		  cartlist.add(cart);
    		  response.sendRedirect("index.jsp");
    	  }
    	  }
     
    }
    }