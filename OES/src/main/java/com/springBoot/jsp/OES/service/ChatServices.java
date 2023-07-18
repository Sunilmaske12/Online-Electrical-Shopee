package com.springBoot.jsp.OES.service;

import java.util.List;

import com.springBoot.jsp.OES.entity.chat;

public interface ChatServices {

	List<chat> getAllTicket();

	void updateTicketStatus(int id, String action);

	int getNewQueryCount();


}
