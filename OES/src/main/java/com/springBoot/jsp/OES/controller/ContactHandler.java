package com.springBoot.jsp.OES.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactHandler {
	
	@GetMapping("/contact")
	public String contactPage() {
		
		
		return "contact";
	}

}
