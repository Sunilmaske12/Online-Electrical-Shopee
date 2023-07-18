package com.springBoot.jsp.OES.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.jsp.OES.entity.Banner;
import com.springBoot.jsp.OES.entity.Category;
import com.springBoot.jsp.OES.service.BannerServices;
import com.springBoot.jsp.OES.service.ChatServices;
import com.springBoot.jsp.OES.service.OrderServices;
import com.springBoot.jsp.OES.service.ProductService;
import com.springBoot.jsp.OES.service.UserServices;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private BannerServices bannerService;
	
	@Autowired
	private UserServices userService;
	
	@Autowired
	private OrderServices orderServices;
	
	@Autowired
	private ChatServices chatServices;
	
	@RequestMapping("/")
	public String indexPage(Model model) {
		List<Category> allCategories = productService.getAllCategories();
		List<Banner> allBanner = bannerService.getAllBanner();
		model.addAttribute("allCategories", allCategories);
		model.addAttribute("allBanner", allBanner);
		return "index";
	}

	@GetMapping("/loginForm")
	public String getLoginPage(Model model) {
		// DailyBusiness dailyOnline
		return "loginform";
	}

	

	@GetMapping("/addProduct")
	public String getAddProductPage(Model model) {
		// DailyBusiness dailyOnline
		return "Add-product";
	}

	@GetMapping("/calender")
	public String getCalenderPage(Model model) {
		// DailyBusiness dailyOnline
		return "calender";
	}


	@GetMapping("/adminPannel")
	public String getDashboard(Model model) {
		int newUsers = userService.getNewUserCount();
		int newOrders = orderServices.getNewOrderCount();
		int newQuery = chatServices.getNewQueryCount();
		int notificationCount=0;
		int totalUsers = userService.getUserCount();
		int totalOrders = orderServices.getOrderCount();
		int totalSales = orderServices.getTotalSales();
		if(newUsers!=0) {
			notificationCount +=1;
		}
		if(newOrders!=0) {
			notificationCount +=1;
		}
		if(newQuery!=0) {
			notificationCount +=1;
		}
		model.addAttribute("newUserCount", newUsers);
		model.addAttribute("newOrdersCount", newOrders);
		model.addAttribute("newQueryCount", newQuery);
		model.addAttribute("notificationCount", notificationCount);
		model.addAttribute("userCount", totalUsers);
		model.addAttribute("ordersCount", totalOrders);
		model.addAttribute("totalSales", totalSales);
		model.addAttribute("totalEarning", totalSales*0.2);
		return "dashbord";
	}

	
	 
}
