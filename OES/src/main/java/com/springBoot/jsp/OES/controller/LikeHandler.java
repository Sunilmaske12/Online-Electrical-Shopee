package com.springBoot.jsp.OES.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LikeHandler {
	
	@GetMapping("/likeProduct")
	public String showLike() {
		return "like_product";
	}
}
