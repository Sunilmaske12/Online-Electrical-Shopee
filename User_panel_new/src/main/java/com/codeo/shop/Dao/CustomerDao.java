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
	private static final String INSERT_CUSTO_DETAIL = "insert into customer_order ( Customer_Name,Contact, Email, Address, Landmark, Address_Type, City, Pincode, user_Id) values(?,?,?,?,?,?,?,?,?)" ;
	
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
			String select_address="select * from customer_order where user_Id="+u_id;
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

		
	

	public boolean orderPlace(String address, String payment, String user_id) {
		 String query = "insert into demo (A,B,C) values(?,?,?)" ;
			System.out.print("address  "+address);
			System.out.print("payment "+payment);
			System.out.print("user_id    "+user_id);
		 Connection con = ConnectionProvider.getconnection();;
		 PreparedStatement psmt = null ;
		boolean flag=false;
		
		
			
			int result = 0;
			if(con != null)
			{
				try {
					psmt = con.prepareStatement(query);
					if(psmt!=null)
					{
						psmt.setString(1, address);
						psmt.setString(2, payment);
						psmt.setString(3, user_id);
							
					}
					if(psmt!=null)
					{
						result = psmt.executeUpdate();
						flag=true;
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
				
			}
			
		}
		
		return flag;
	}

	


} 
