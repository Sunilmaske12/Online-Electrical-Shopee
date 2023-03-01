package com.codeo.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.codeo.shop.dbutil.ConnectionProvider;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class GmailSenderDao {
	

	public boolean sendEmail(String to, String from, String subject, String text) {
		boolean flag=false;
		
		//smtp properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		
		String Password="yricfzxqtdcoxige";
		String Username="sunilmaske2001@gmail.com";
		//session create
		Session session=Session.getInstance(props, new Authenticator() {
		@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(Username, Password);
																								
			}
		});
		
		try {
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	public int getUserDatailsbyEmail(String email) {
		 int count = 0;
			Connection con = null;
			con = ConnectionProvider.getconnection();
			String query= "select * from user_registration where user_emailid=?";
			ResultSet rs=null;
			try {
			 PreparedStatement ps = con.prepareStatement(query);
			 ps.setString(1, email);
			           rs = ps.executeQuery();
			          
			  		 while(rs.next()) {
			  			  count=rs.getInt(1);
			  		 }
	    
			}catch(Exception e) {
				e.printStackTrace();
			}
	           
	            return count;
	           
	}

	public void setNewPassword(String email, String newPassword) {
		
		try {
			Connection con = null;
			con = ConnectionProvider.getconnection();
			PreparedStatement pst = con.prepareStatement("update user_registration set user_pass = ? where user_emailid = ? ");
			pst.setString(1, newPassword);
			pst.setString(2, email);

			 pst.executeUpdate();
			
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
