package com.codeo.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeo.shop.dbutil.ConnectionProvider;
import com.codeo.shop.entity.Customer;
import com.codeo.shop.entity.Order;

public class MyOrderDao {

	static Connection con = ConnectionProvider.getconnection();
	static PreparedStatement psmt = null;

	ResultSet rs = null;

	public List<Order> getAllOrderListByUID(int uid) {
		List<Order> list = new ArrayList<Order>();
		String Select_Order = "select * from customer_order where User_Id=" + uid;
		try {
			Statement st;
			st = con.createStatement();
			rs = st.executeQuery(Select_Order);
			Order order = null;
			while (rs.next()) {
				order = new Order();
				order.setOrderId(rs.getInt("Order_Id"));
				order.setDate(rs.getDate("Date"));
				order.setAddressId(rs.getString("C_Address_Id"));
				order.setCharges(rs.getInt("Shipping_Charges"));
				order.setStatus(rs.getString("Status"));
				order.setTotal_Amount(rs.getInt("Total_Amount"));
				order.setAmount(rs.getInt("Amount"));
				
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<Order> getAllOrderList() {
		List<Order> list = new ArrayList<Order>();
		String Select_Order = "select * from customer_order";
		try {
			psmt = con.prepareStatement(Select_Order);
			rs = psmt.executeQuery();
			Order order = null;
			while (rs.next()) {
				order = new Order();
				order.setOrderId(rs.getInt("Order_Id"));
				order.setDate(rs.getDate("Date"));
				order.setAddressId(rs.getString("C_Address_Id"));
				order.setCharges(rs.getInt("Shipping_Charges"));
				order.setStatus(rs.getString("Status"));
				order.setTotal_Amount(rs.getInt("Total_Amount"));
				order.setAmount(rs.getInt("Amount"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<Customer> getAddressDetailByID(String uid) {
		List<Customer> clist = new ArrayList<Customer>();
		String Select_Address = "select * from customer_address where Address_Id=" + uid;
		try {
			psmt = con.prepareStatement(Select_Address);
			rs = psmt.executeQuery();
			Customer custo = null;
			while (rs.next()) {
				custo = new Customer();
				custo.setC_name(rs.getString("Customer_Name"));
				custo.setC_mobno(rs.getString("Contact"));
				custo.setC_email(rs.getString("Email"));
				custo.setC_adderess(rs.getString("Address"));
				custo.setC_landmark(rs.getString("Landmark"));
				custo.setC_AddressType(rs.getString("Address_Type"));
				custo.setC_city(rs.getString("City"));
				custo.setC_pincode(rs.getString("Pincode"));
				clist.add(custo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clist;

	}

	public List<Order> getOrderDetails(String uid) {
		List<Order> olist = new ArrayList<Order>();
		String Select_Address = "select * from customer_order_details where Order_Id=" + uid;
		try {
			psmt = con.prepareStatement(Select_Address);
			rs = psmt.executeQuery();
			Order order = null;
			while (rs.next()) {
				order = new Order();
				order.setProductId(rs.getInt("Product_Id"));
				order.setProductName(rs.getString("Product_Name"));
				order.setProductPrice(rs.getInt("Product_Price"));
				order.setProductQuantity(rs.getInt("Product_Quantity"));
				
				olist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olist;

	}

	public boolean approvedOrder(String o_Id) {
		String approve = "update customer_order set Status=? where Order_Id=?";
		boolean flag = false;
		Connection con = ConnectionProvider.getconnection();

		try (PreparedStatement psmt = con.prepareStatement(approve)) {

			psmt.setString(1, "Approved");
			psmt.setString(2, o_Id);
			psmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean rejectOrder(String o_Id) {
		String approve = "update customer_order set Status=? where Order_Id=?";
		boolean flag = false;
		Connection con = ConnectionProvider.getconnection();

		try (PreparedStatement psmt = con.prepareStatement(approve)) {

			psmt.setString(1, "Rejected");
			psmt.setString(2, o_Id);
			psmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	
}
