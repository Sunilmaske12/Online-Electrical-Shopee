package com.codeo.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.codeo.shop.dbutil.ConnectionProvider;

public class NotificationDao {
	static Connection con=ConnectionProvider.getconnection();
	static PreparedStatement psmt=null;
	static Statement statement=null;
	static ResultSet rs=null;
	static int result=0;
	
	public static int getNewUser() throws SQLException {
		int result=0;
		String select="select count(user_name) from user_registration where Seen='No'";
		statement=con.createStatement();
		if(statement!=null) {
			rs=statement.executeQuery(select);
			rs.next();
			result=rs.getInt(1);
		}
		return result;
	}
	
	public static int getNewOrder() throws SQLException {
		int result=0;
		String select="select count(Order_Id) from customer_order where Seen='No'";
		statement=con.createStatement();
		if(statement!=null) {
			rs=statement.executeQuery(select);
			rs.next();
			result=rs.getInt(1);
		}
		return result;
	}
	
	public static int getNewQuery() throws SQLException {
		int result=0;
		String select="select count(ChatId) from query_chats where Seen='No'";
		statement=con.createStatement();
		if(statement!=null) {
			rs=statement.executeQuery(select);
			rs.next();
			result=rs.getInt(1);
		}
		return result;
	}
	
	public static void seenOrderById(String O_Id) throws SQLException {
		String update="update customer_order set Seen='Yes' where Order_Id="+O_Id;
		psmt=con.prepareStatement(update);
		if(psmt!=null) {
			psmt.executeUpdate();
		}
	}
	
	public static void seenChatById(String C_Id) throws SQLException {
		String update="update query_chats set Seen='Yes' where ChatId="+C_Id;
		psmt=con.prepareStatement(update);
		if(psmt!=null) {
			psmt.executeUpdate();
		}
	}
	
	public static void seenQueryById(String T_Id) throws SQLException {
		String update="update ticket_query set Seen='Yes' where TicketId="+T_Id;
		psmt=con.prepareStatement(update);
		if(psmt!=null) {
			psmt.executeUpdate();
		}
	}
	
	public static void seenUser() throws SQLException {
		String update="update user_registration set Seen='Yes'";
		psmt=con.prepareStatement(update);
		if(psmt!=null) {
			psmt.executeUpdate();
		}
	}
	
}
