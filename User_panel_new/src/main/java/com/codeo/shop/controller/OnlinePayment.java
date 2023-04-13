package com.codeo.shop.controller;
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import org.json.JSONObject;

	import com.razorpay.*;

	@WebServlet("/OnlinePayment")
	public class OnlinePayment extends HttpServlet {
		
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession s=request.getSession();
			String	C_AddressId=request.getParameter("address_id");
			System.out.println("====Address id===="+C_AddressId);
			//String razopayPaymentId=request.getParameter("paymentId");
			if(C_AddressId==null) {
				s.setAttribute("incompleteinfo","No address");
				response.sendRedirect("checkout.jsp");
				return;
			}
			
			String amount=(String)s.getAttribute("TotalAmount");
		if(amount!=null) {
			int payment=100*Integer.parseInt(amount);
				try {
				RazorpayClient client=new RazorpayClient("rzp_test_7TxMC9UB8XmbM0", "r6r09iYcHJk4WkPxByNFhHkn");
				JSONObject obj=new JSONObject();
				obj.put("amount", payment);
				obj.put("currency", "INR");
				obj.put("receipt", "txn_1234");
				
				//creating order
				Order order=client.orders.create(obj);
				System.out.println(order);	
				String o_id=order.get("id");
				
			s.setAttribute("o_id", o_id);
			s.setAttribute("addressId", C_AddressId);					
			} catch (RazorpayException e) {
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("orderPlace.jsp");
	}
	}
