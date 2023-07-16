package com.springBoot.jsp.OES.service;

import java.util.List;

import com.springBoot.jsp.OES.entity.Order;
import com.springBoot.jsp.OES.entity.OrderDetails;

public interface OrderServices {

	public List<Order> getAllOrder();

	public List<OrderDetails> getOrderDetailById(int oid);

}
