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
import com.springBoot.jsp.OES.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private BannerServices bannerService;
	
	
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

	

	
	

	@GetMapping("/viewCategory")
	public String getviewCategorypage(Model model) {
		// DailyBusiness dailyOnline
		return "View_Category";

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

	@GetMapping("/support")
	public String getSupportPage(Model model) {
		// DailyBusiness dailyOnline
		return "support";
	}

	/*
	 * @GetMapping("/adminPannel") public String getDashboard(Model model) {
	 * //DailyBusiness dailyOnline return "dashbord"; }@GetMapping("/adminPannel")
	 * public String getDashboard(Model model) { //DailyBusiness dailyOnline return
	 * "dashbord"; }@GetMapping("/adminPannel") public String getDashboard(Model
	 * model) { //DailyBusiness dailyOnline return "dashbord"; }
	 */

	@GetMapping("/adminPannel")
	public String getDashboard(Model model) {
		// DailyBusiness dailyOnline
		return "dashbord";
	}

	
	 
}
