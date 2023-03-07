package com.codeo.shop.entity;

import java.sql.Date;
import java.sql.Time;

public class chat {

	String userId;
	String userName; 
	String status; 
	String ticketId;
	Date ticket_date;
	Time ticket_time;
	Date chat_date;
	Time chat_time;
	String message;
	String Admin_Manager;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public Date getTicket_date() {
		return ticket_date;
	}
	public void setTicket_date(Date ticket_date) {
		this.ticket_date = ticket_date;
	}
	public Time getTicket_time() {
		return ticket_time;
	}
	public void setTicket_time(Time ticket_time) {
		this.ticket_time = ticket_time;
	}
	public Date getChat_date() {
		return chat_date;
	}
	public void setChat_date(Date chat_date) {
		this.chat_date = chat_date;
	}
	public Time getChat_time() {
		return chat_time;
	}
	public void setChat_time(Time chat_time) {
		this.chat_time = chat_time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getAdmin_Manager() {
		return Admin_Manager;
	}
	public void setAdmin_Manager(String admin_Manager) {
		Admin_Manager = admin_Manager;
	}
	
	@Override
	public String toString() {
		return "chat [userId=" + userId + ", userName=" + userName + ", status=" + status + ", ticketId=" + ticketId
				+ ", ticket_date=" + ticket_date + ", ticket_time=" + ticket_time + ", chat_date=" + chat_date
				+ ", chat_time=" + chat_time + ", message=" + message + ", Admin_Manager=" + Admin_Manager + "]";
	}
	
	public chat(String userId, String userName, String status, String ticketId, Date ticket_date, Time ticket_time,
			Date chat_date, Time chat_time, String message, String admin_Manager) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.status = status;
		this.ticketId = ticketId;
		this.ticket_date = ticket_date;
		this.ticket_time = ticket_time;
		this.chat_date = chat_date;
		this.chat_time = chat_time;
		this.message = message;
		Admin_Manager = admin_Manager;
	}
	public chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
