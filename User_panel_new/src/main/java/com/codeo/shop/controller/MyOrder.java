package com.codeo.shop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeo.shop.Dao.CustomerDao;


@WebServlet("/orderPlace")
public class MyOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	String C_AddressId;
	String Payment_Mode;
	String U_id;
	String T_Price;
	String paymentId;
	String razopayOrderId;
	RequestDispatcher dispatcher = null;
	 
    public MyOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		
		C_AddressId = (String)session.getAttribute("addressId");
		System.out.println("=====Address id in myorder======");
		paymentId=request.getParameter("paymentId");
		System.out.println("============="+paymentId);
		if(paymentId==null || paymentId=="") {
			Payment_Mode="Cash On Delivery";
		}else {
			Payment_Mode="Online Paid";
		}
		
		if(Payment_Mode==null) {
			session.setAttribute("incompleteinfo","No Payment");
			response.sendRedirect("checkout.jsp");
			return;
		}
		
		U_id=request.getParameter("user_id");
		T_Price=request.getParameter("tprice");
		
		 razopayOrderId=request.getParameter("razorpayOrdertId");
		 String Pid[]=request.getParameterValues("productIdO");
		 String Pname[]=request.getParameterValues("productNameO");
		 String Pquantity[]=request.getParameterValues("productQuantityO");
		 String Pprice[]=request.getParameterValues("productPriceO");
		
		CustomerDao cd=new CustomerDao();
		if(cd.placeOrder(razopayOrderId, C_AddressId, U_id, T_Price, Payment_Mode)) {
			int orderId=0;
			try {
				 orderId=cd.getOrderId();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cd.orderPlace(Pid, Pname, Pquantity, Pprice, orderId)) {
				System.out.print("detail is inserted");
				session.setAttribute("orderSuccess"," Success");
				razopayOrderId=null;
				//razopayPaymentId=null;
				session.removeAttribute("o_id");
				session.removeAttribute("addressId");
				session.removeAttribute("razorpayPaymentId");
				response.sendRedirect("MyOrders.jsp");
			
			}
			
			//saving daily business growth
			int todaysDateId=0;
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String str=sdf.format(date);
			//String str="2023-01-25";
			try {
				todaysDateId=cd.getTodaysDateId(str);
				System.out.println("order id "+todaysDateId);
				int  dailySell = cd.getDailySell(str);
				int dailyProfit = 0;
				int dailyOnlinePayment = 0;
				int dailyCahOnDelivery = 0;
				//inserting 1 st time in a day sell in 
				if(todaysDateId!=0) {
					 dailyProfit = (int) (dailySell*0.2);
					 dailyOnlinePayment = cd.getDailyOnlinePayment(str);
					 dailyCahOnDelivery = cd.getDailyCashOnDelivery(str);
					//cd.updateDailyOnlineBusiness(str, dailySell,dailyProfit, dailyOnlinePayment, dailyCahOnDelivery);
					dailySell= dailySell+Integer.parseInt(T_Price);
					if(Payment_Mode.equals("Online Paid")) {
						dailyOnlinePayment = dailyOnlinePayment+Integer.parseInt(T_Price);
					
					}else {
						dailyCahOnDelivery = dailyCahOnDelivery +Integer.parseInt(T_Price);
					}
					cd.updateDailyCashBusiness(str, dailySell,dailyProfit, dailyOnlinePayment, dailyCahOnDelivery);
					System.out.println("daily business data updated");
			
				}else {
					 dailySell=Integer.parseInt(T_Price);
					 dailyProfit= (int)(dailySell*0.2);
					 if(Payment_Mode.equals("Online Paid")) {
							dailyOnlinePayment = dailySell;
							dailyCahOnDelivery=0;
						}else {
							dailyCahOnDelivery = dailySell;
							dailyOnlinePayment =0;
						}
					cd.insertDailyBusiness(str, dailySell,dailyProfit, dailyOnlinePayment, dailyCahOnDelivery);
					System.out.println("daily business data inserted");
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			} 
	}
	}

