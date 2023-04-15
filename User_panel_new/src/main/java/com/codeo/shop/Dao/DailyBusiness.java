package com.codeo.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeo.shop.dbutil.ConnectionProvider;
//import com.codeo.shop.entity.Order;

public class DailyBusiness {
	static Connection con = ConnectionProvider.getconnection();;
	static PreparedStatement psmt = null ;
	ResultSet rs;
	
	public int[] getOnlineSell() throws SQLException {
		
		String Select_Sell = "select DailyOnlinePayment from dailybusiness";
		
			psmt = con.prepareStatement(Select_Sell);
			
			rs = psmt.executeQuery();
			int i=0;
			while (rs.next()) {
				i++;
			}
			int[] arr=new int[i+1];
			int j=0;
			rs.first();
			while (rs.next()) {
				arr[j]=rs.getInt(1);
				j++;
			}
		return arr;
	}
	
	
	public int[] getCashSell(int size) {
		int[] arr=new int[size];
		String Select_Sell = "select DailyCashOnDelivery from dailybusiness";
		try {
			psmt = con.prepareStatement(Select_Sell);
			rs = psmt.executeQuery();
			int i=0;
			while (rs.next()) {
				arr[i]=rs.getInt(1);
				
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;

	}

	public String[] getDate(int size) {
		String[] arr=new String[size];
		String Select_Sell = "select Date from dailybusiness";
		try {
			psmt = con.prepareStatement(Select_Sell);
			
			rs = psmt.executeQuery();
			int i=0;
			while (rs.next()) {
				arr[i]=rs.getString(1);
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public long getTotalProductPrice() {
		String Select_Sell = "select sum(prod_price*prod_quantity) from product_operation ";
		long t_price=0;
		try {
			psmt = con.prepareStatement(Select_Sell);
			rs = psmt.executeQuery();
			while (rs.next()) {
			t_price=rs.getLong(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_price;
	}
	
	public long getTotalAppliancesPrice() {
		String Select_Sell = "select sum(prod_price*prod_quantity) from product_operation  where cid=12";
		long t_price=0;
		try {
			psmt = con.prepareStatement(Select_Sell);
			rs = psmt.executeQuery();
			while (rs.next()) {
			t_price=rs.getLong(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_price;
	}
	
	public long getTotalFansPrice() {
		String Select_Sell = "select sum(prod_price*prod_quantity) from product_operation where cid=10";
		long t_price=0;
		try {
			psmt = con.prepareStatement(Select_Sell);
			rs = psmt.executeQuery();
			while (rs.next()) {
			t_price=rs.getLong(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_price;
	}
	
	public long getTotalToolsPrice() {
		String Select_Sell = "select sum(prod_price*prod_quantity) from product_operation where cid=15";
		long t_price=0;
		try {
			psmt = con.prepareStatement(Select_Sell);
			rs = psmt.executeQuery();
			while (rs.next()) {
			t_price=rs.getLong(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_price;
	}
	
	public int[] getStatus() {
		int[] arr=new int[4];
		String status = "select Status from customer_order";
		try {
			psmt = con.prepareStatement(status);
			
			rs = psmt.executeQuery();
			int t=0, s=0, r=0, w=0;
			
			while (rs.next()) {
				t++;
				if(rs.getString(1).equals("Approved")) {
					s++;
				}else 
					if(rs.getString(1).equals("Rejected")) {
						r++;
					} else
						{
						w++;	
						}
			}
			arr[0]=t;
			arr[1]=s;
			arr[2]=r;
			arr[3]=w;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
