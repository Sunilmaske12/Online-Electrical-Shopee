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
				System.out.println("online");
			}
			int[] arr=new int[i+1];
			int j=0;
			rs.first();
			while (rs.next()) {
				arr[j]=rs.getInt(1);
				System.out.println("online"+arr[j]);
				j++;
			}
			System.out.println(arr.length);	
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
			for(int k=0; k<arr.length; k++) {
				System.out.println(arr[k]);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;

	}


}
