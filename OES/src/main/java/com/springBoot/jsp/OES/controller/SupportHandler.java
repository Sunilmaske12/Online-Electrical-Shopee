package com.springBoot.jsp.OES.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springBoot.jsp.OES.entity.chat;
import com.springBoot.jsp.OES.service.ChatServices;

@Controller
public class SupportHandler {
	
	@Autowired
	private ChatServices chatServices;
	
	@GetMapping("/support")
	public String getSupportAdminPage(Model model) {
		List<chat> allTickets = chatServices.getAllTicket();
		model.addAttribute("allTickets", allTickets);
		return "support";
	}
	
	
	@GetMapping("/adminChat{TicketId}")
	public String getChatsAdminPage(Model model) {
//		model.addAttribute("allTickets", allTickets);
		return "";
	}
	
	@GetMapping("/ticketStatusUpdate,{Action},{TicketId}")
	public String ticketStatusClose(@PathVariable("TicketId") int id,@PathVariable("Action") String action) {
		switch(action) {
		case "Open": chatServices.updateTicketStatus(id, "Open");
		case "Close": chatServices.updateTicketStatus(id, "Close");

		}
		
		return "redirect:/support";
	}

}
