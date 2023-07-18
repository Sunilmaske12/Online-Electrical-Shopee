package com.springBoot.jsp.OES.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="ticket_query")
public class chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TicketId;
	private int UserId;
	private String UserName; 
	private Date Date;
	private Time Time;
	private String Status;
	private String Admin_Manager;
	private String seen;
	public int getTicketId() {
		return TicketId;
	}
	public void setTicketId(int ticketId) {
		TicketId = ticketId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public Time getTime() {
		return Time;
	}
	public void setTime(Time time) {
		Time = time;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getAdmin_Manager() {
		return Admin_Manager;
	}
	public void setAdmin_Manager(String admin_Manager) {
		Admin_Manager = admin_Manager;
	}
	public String getSeen() {
		return seen;
	}
	public void setSeen(String seen) {
		this.seen = seen;
	}
	
	
	
	
}
