package com.codeo.shop.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeo.shop.Dao.ProductDao;
import com.codeo.shop.Dao.ProductDaoImp;
import com.codeo.shop.entity.Cart;
import com.codeo.shop.entity.Product;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  //prod_id, prod_name, prod_description, prod_price, prod_discount, prod_quantity, prod_imageName, cid
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int prod_id = Integer.parseInt(request.getParameter("prod_id"));
        String prod_name=request.getParameter("prod_name");
        String prod_price= request.getParameter("prod_price");
        String prod_imageName= request.getParameter("prod_imageName");
        
        HttpSession session = request.getSession();
        
        System.out.println(prod_id);
        
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        
       // int id = Integer.parseInt(request.getParameter("productId"));
        String prod_quantity =request.getParameter("prod_quantity");

        ProductDao productDao = new ProductDaoImp();
        
        Product product = productDao.getProduct(prod_id);
        cart.addProduct(product, prod_quantity);
         response.sendRedirect("AddToCart.jsp");
    }
}
