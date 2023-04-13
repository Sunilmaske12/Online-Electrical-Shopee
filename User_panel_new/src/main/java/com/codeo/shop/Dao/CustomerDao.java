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

public class CustomerDao {
	private static final String INSERT_CUSTO_DETAIL = "insert into customer_address ( Customer_Name,Contact, Email, Address, Landmark, Address_Type, City, Pincode, user_Id) values(?,?,?,?,?,?,?,?,?)" ;
	
	static Connection con = ConnectionProvider.getconnection();;
	static PreparedStatement psmt = null ;
	
	
	public void insertCustoDetail(Customer customer) {
		
		int result = 0;
		if(con != null)
		{
			try {
				psmt = con.prepareStatement(INSERT_CUSTO_DETAIL);
				if(psmt!=null)
				{
					psmt.setString(1, customer.getC_name());
					psmt.setString(2, customer.getC_mobno());
					psmt.setString(3, customer.getC_email());
					psmt.setString(4, customer.getC_adderess());
					psmt.setString(5, customer.getC_landmark());
					psmt.setString(6, customer.getC_AddressType());
					psmt.setString(7, customer.getC_city());
					psmt.setString(8, customer.getC_pincode());
					psmt.setString(9, customer.getU_id());
					
					
				}
				if(psmt!=null)
				{
					result = psmt.executeUpdate();
				}
				
				if(result!=0)
				{
					System.out.println("data is inserted");
				}
				else
				{
					System.out.println("data is not inserted");
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	//get customer addresses
		 public List <Customer> getAddress(int u_id)
			{
				List<Customer> address = new ArrayList<Customer>();
				Customer custo_address = null;
			
		try {
			String select_address="select * from customer_address where user_Id="+u_id;
			Statement statement = con.createStatement();
			ResultSet resultset =null;
			resultset =statement.executeQuery(select_address);
			//prod_id, prod_name, prod_description, prod_price, prod_discount, prod_quantity, prod_imageName
			while(resultset.next())
			{
				custo_address = new Customer();
				custo_address.setC_name(resultset.getString("Customer_Name"));
				custo_address.setC_adderess(resultset.getString("Address"));
				custo_address.setC_city(resultset.getString("City"));
				custo_address.setC_landmark(resultset.getString("Landmark"));
				custo_address.setC_mobno(resultset.getString("Contact"));
				custo_address.setC_pincode(resultset.getString("Pincode"));
				custo_address.setC_id(resultset.getString("Address_Id"));
				
				address.add(custo_address);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
			return address;
			}
		
	

	public boolean deleteUser(int id) {
			return false;
	}

	
	public boolean placeOrder(String razorpayOrderId, String C_AddressId, String u_id, String t_Price, String payment_Mode) {
		boolean flag=false;
		int charges=0;
		if(Integer.parseInt(t_Price)<999) {
			charges=100;
		}
		int TotalAmount=Integer.parseInt(t_Price)+charges;
		Connection con=ConnectionProvider.getconnection();
		PreparedStatement psmt=null;
		if(con!=null) {
		
			String insert_order="insert into customer_order (C_Address_Id, User_Id, Amount, Shipping_Charges, Total_Amount, Payment_Mode, Status,RazorpayOrderId) values(?,?,?,?,?,?,?,?)";
			
				
				try {
					psmt=con.prepareStatement(insert_order);
					if(psmt!=null) {
						psmt.setString(1, C_AddressId);
						psmt.setString(2, u_id);
						psmt.setString(3, t_Price);
						psmt.setLong(4, charges);
						psmt.setLong(5, TotalAmount);
						psmt.setString(6, payment_Mode);
						psmt.setString(7, "Waiting");
						psmt.setString(8, razorpayOrderId);
						 psmt.executeUpdate();
						flag=true;
					}
						
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		
		return flag;
	}


	public int getOrderId() throws SQLException {
		int result=0;
		if(con!=null) {
			String getId= "select Order_Id from customer_order ";
			
			psmt = con.prepareStatement(getId);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				 result=rs.getInt("Order_Id");
			}
		}
		
		return result;
	}
	

	public boolean orderPlace(String[] pid, String[] pname, String[] pquantity, String[] pprice, int orderId) {
		boolean flag=false;
		
		Connection con=ConnectionProvider.getconnection();
		PreparedStatement psmt=null;
		if(con!=null) {
			int i;
			String insert_order="insert into customer_order_details (Order_Id, Product_Id, Product_Name, Product_Price,Product_Quantity) values(?,?,?,?,?)";
			for(i=0; i<pid.length; i++) {
				
				try {
					psmt=con.prepareStatement(insert_order);
					if(psmt!=null) {
						psmt.setInt(1,orderId);
						psmt.setString(2,pid[i]);
						psmt.setString(3, pname[i]);
						psmt.setString(4, pprice[i]);
						psmt.setString(5, pquantity[i]);
						 psmt.executeUpdate();
						flag=true;
						System.out.println("order is inserted");
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return flag;
	}
	 
	public static  int getTotalOrderCount() throws SQLException{
		String count_query= "select Count(Order_Id) from customer_order ";
		
		psmt = con.prepareStatement(count_query);
		ResultSet rs = psmt.executeQuery();
		int count=0;
		while(rs.next()) {
			 count=rs.getInt(1);
		}
		
			
		return count;
				
	}

	public static  int getTotalSales() throws SQLException{
		String count_query= "select Sum(Total_Amount) from customer_order ";
		
		psmt = con.prepareStatement(count_query);
		ResultSet rs = psmt.executeQuery();
		int count=0;
		while(rs.next()) {
			 count=rs.getInt(1);
		}
		return count;
	}

	public int getTodaysDateId(String str) throws SQLException {
		String date="'"+str+"'";
		String select_Id="select Sr_No from dailybusiness where Date="+date;
		psmt=con.prepareStatement(select_Id);
		ResultSet rs=psmt.executeQuery();
		int id=0;
		while(rs.next()) {
		id=rs.getInt(1);
		System.out.println(id);
		}
		
		return id;
	}

	public void insertDailyBusiness(String str, int dailySell,int dailyProfit, int dailyOnlinePayment, int dailyCahOnDelivery) throws SQLException {
		String insert_business="insert into dailybusiness (Date, DailySell, DailyProfit, DailyOnlinePayment, DailyCashOnDelivery) values  (?,?,?,?,?)"; 
		psmt = con.prepareStatement(insert_business);
		if(psmt!=null) {
			psmt.setString(1, str);
			psmt.setLong(2, dailySell);
			psmt.setLong(3, dailyProfit);
			psmt.setLong(4, dailyOnlinePayment);
			psmt.setLong(5, dailyCahOnDelivery);
		}
		psmt.executeUpdate();
	}

	public int getDailySell(String str) throws SQLException {
		String date="'"+str+"'";
String count_query= "select Sum(Total_Amount) from customer_order where Date="+date;
		
		psmt = con.prepareStatement(count_query);
		ResultSet rs = psmt.executeQuery();
		int count=0;
		while(rs.next()) {
			 count=rs.getInt(1);
		}
		return count;
	}

	public int getDailyCashOnDelivery(String str) throws SQLException {
		String date="'"+str+"'";
		String count_query= "select Sum(Total_Amount) from customer_order where Date="+date+" and Payment_Mode='Cash On Delivery'";
				
				psmt = con.prepareStatement(count_query);
				
				ResultSet rs = psmt.executeQuery();
				int count=0;
				while(rs.next()) {
					 count=rs.getInt(1);
					 System.out.println("inside while"+count);
				}
				System.out.println("outside while"+count);
				return count;
	}

	public int getDailyOnlinePayment(String str) throws SQLException {
		String date="'"+str+"'";
		String count_query= "select Sum(Total_Amount) from customer_order where Date="+date+" and Payment_Mode='Online Paid'";
		psmt = con.prepareStatement(count_query);
			ResultSet rs = psmt.executeQuery();
				int count=0;
				while(rs.next()) {
					 count=rs.getInt(1);
					 System.out.println("inside while"+count);
				}
				System.out.println("outside while"+count);
				return count;
	}

	public void updateDailyCashBusiness(String str, int dailySell, int dailyProfit, int dailyOnlinePayment,
			int dailyCahOnDelivery) throws SQLException {
		String date="'"+str+"'";
		String update="update dailybusiness set DailySell=?, DailyProfit=?, DailyOnlinePayment=?, DailyCashOnDelivery=? where Date="+date;
		psmt=con.prepareStatement(update);
		if(psmt!=null) {
			psmt.setLong(1, dailySell);
			psmt.setInt(2, dailyProfit);
			psmt.setInt(3, dailyOnlinePayment);
			psmt.setInt(4, dailyCahOnDelivery);
		}
	}


} 
