package com.springBoot.jsp.OES.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springBoot.jsp.OES.entity.Customer;
import com.springBoot.jsp.OES.entity.Order;
import com.springBoot.jsp.OES.entity.OrderDetails;
import com.springBoot.jsp.OES.service.OrderServices;
import com.springBoot.jsp.OES.service.CustomerServices;


@Controller
public class OrderController {
	
	@Autowired
	private OrderServices orderServices;
	
	@Autowired
	private CustomerServices customerServices;
	
	
	@GetMapping("/MyOrders")
	public String myMyOrders(Model model) {
	List<Order> allOrders = orderServices.getAllOrder();
	model.addAttribute("allOrders", allOrders);
		return "MyOrders";
	}
	
	@GetMapping("/OrderDetails{oid},{aid}")
	public String myOrderDetails(Model model, @PathVariable("oid") int Oid,  @PathVariable("aid") int Aid) {
		Customer customer = customerServices.getCustomerById(Aid);
		List<OrderDetails> orderDetails = orderServices.getOrderDetailById(Oid); 
	model.addAttribute("customerDetails", customer);
	model.addAttribute("OrderDetails", orderDetails);
	//if(orderDetails.getAmount()*orderDetails.get)
	//model.addAttribute("charges")
		return "OrderDetails";
	}
	
	@GetMapping("/viewOrderAdmin")
	public String getAdminOrderPage(Model model) {
		List<Order> allOrders = orderServices.getAllOrder();
		model.addAttribute("allOrders", allOrders);
		return "ViewOrderAdmin";
	}
	

}
