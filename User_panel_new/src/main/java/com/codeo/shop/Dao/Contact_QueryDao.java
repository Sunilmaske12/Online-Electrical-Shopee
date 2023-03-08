package com.codeo.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.codeo.shop.dbutil.ConnectionProvider;
import com.codeo.shop.entity.chat;

public class Contact_QueryDao {

	static Connection con=ConnectionProvider.getconnection();
	static PreparedStatement psmt=null;
	int result=0;
	ResultSet rs=null;
	public boolean ticketGenerate(String userId, String userName) {
		boolean flag=false;
		String insert_query="insert into ticket_query (UserId, UserName, Status) values(?,?,?)";
		try {
			psmt=con.prepareStatement(insert_query);
			psmt.setString(1, userId);
			psmt.setString(2, userName);
			psmt.setString(3, "Waiting");
			result=psmt.executeUpdate();
			if(result!=0) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	

	public String getTicketId() {
		String select_query="select TicketId from ticket_query";
		String OId=null;
		try {
			psmt=con.prepareStatement(select_query);
			rs=psmt.executeQuery();
			while(rs.next()) {
				 OId=rs.getString("TicketId");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OId;
	}

	public boolean chatSendToAmdin(String ticketId, String userName, String message) {
		boolean flag=false;
		String insert_query="insert into query_chats (TicketId,  UserName, chat, Sender) values(?,?,?,?)";
		try {
			psmt=con.prepareStatement(insert_query);
			psmt.setString(1, ticketId);
			psmt.setString(2, userName);
			psmt.setString(3, message);
			psmt.setString(4, userName);
			result=psmt.executeUpdate();
			if(result!=0) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public boolean chatSendToUser(String ticketId, String adminName, String message) {
		boolean flag=false;
		String insert_query="insert into query_chats (TicketId,  Admin_Manager, chat, Sender) values(?,?,?,?)";
		try {
			psmt=con.prepareStatement(insert_query);
			psmt.setString(1, ticketId);
			psmt.setString(2, adminName);
			psmt.setString(3, message);
			psmt.setString(4, adminName);
			result=psmt.executeUpdate();
			if(result!=0) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public List<chat> getAllTicketList() {
		List<chat> list = new ArrayList<chat>();
		String Select_ticket = "select * from ticket_query";
		try {
			psmt = con.prepareStatement(Select_ticket);
			rs = psmt.executeQuery();
			chat chat = null;
			while (rs.next()) {
				chat = new chat();
				chat.setTicketId(rs.getString("TicketId"));
				chat.setTicket_date(rs.getDate("Date"));
				chat.setStatus(rs.getString("Status"));
				chat.setSeen(rs.getString("Seen"));
				list.add(chat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}


	public List<chat> getAllTicketListById(int uid) {
		List<chat> list = new ArrayList<chat>();
		String Select_ticket = "select * from ticket_query where UserId=?";
		try {
			psmt = con.prepareStatement(Select_ticket);
			psmt.setLong(1, uid);
			
			rs = psmt.executeQuery();
			chat chat = null;
			while (rs.next()) {
				chat = new chat();
				chat.setTicketId(rs.getString("TicketId"));
				chat.setTicket_date(rs.getDate("Date"));
				chat.setAdmin_Manager(rs.getString("Admin_Manager"));
				chat.setStatus(rs.getString("Status"));
				list.add(chat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	public boolean openChat(String ticket_id, String Admin_Name) {
				String open = "update ticket_query set Status=?, Admin_Manager=? where TicketId=?";
			boolean flag = false;
			try (PreparedStatement psmt = con.prepareStatement(open)) {

				psmt.setString(1, "Open");
				psmt.setString(2, Admin_Name);
				psmt.setString(3, ticket_id);
				psmt.executeUpdate();
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return flag;
		}

	public boolean closeChat(String ticket_id, String Admin_Name) {
		String close = "update ticket_query set Status=?, Admin_Manager=? where TicketId=?";
	boolean flag = false;
	try (PreparedStatement psmt = con.prepareStatement(close)) {

		psmt.setString(1, "Close");
		psmt.setString(2, Admin_Name);
		psmt.setString(3, ticket_id);
		psmt.executeUpdate();
		flag = true;
	} catch (Exception e) {
		e.printStackTrace();
	}

	return flag;
}
	
	public List<chat> getChatsById(String T_ID) {
		List<chat> list = new ArrayList<chat>();
		String Select_chat = "select * from query_chats where TicketId="+T_ID;
		try {
			psmt = con.prepareStatement(Select_chat);
			rs = psmt.executeQuery();
			chat chat = null;
			while (rs.next()) {
				chat = new chat();
				chat.setChat_date(rs.getDate("Date"));
				chat.setChat_time(rs.getTime("Time"));
				chat.setMessage(rs.getString("chat"));
				chat.setAdmin_Manager(rs.getString("Admin_Manager"));
				chat.setUserName(rs.getString("UserName"));
				list.add(chat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}


	
}
