package com.springBoot.jsp.OES.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.jsp.OES.dao.ChatRepository;
import com.springBoot.jsp.OES.entity.chat;

@Service
public class ChatServicesImpl implements ChatServices {
	
	@Autowired
	private ChatRepository chatRepostory;
	
	@Override
	public List<chat> getAllTicket() {
		return chatRepostory.findAll() ;
	}

	@Override
	public void updateTicketStatus(int id, String action) {
		Optional<chat> getTicket = chatRepostory.findById(id);
		chat theTicket = new chat();
		theTicket =  getTicket.get();
		theTicket.setStatus(action);
		chatRepostory.save(theTicket);
	}

	@Override
	public int getNewQueryCount() {
		List<chat> newQuery = chatRepostory.findByseen("No");
		return newQuery.size();
	}

	

}
