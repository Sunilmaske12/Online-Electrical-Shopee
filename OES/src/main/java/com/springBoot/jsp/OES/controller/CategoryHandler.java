package com.springBoot.jsp.OES.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.jsp.OES.entity.Category;
import com.springBoot.jsp.OES.service.CategoryServices;

@Controller
public class CategoryHandler {
	
	@Autowired
	private CategoryServices categoryServices;
	
	
	@RequestMapping("/viewCategoryAdmin")
	public String getAllCategoryAdmin(Model model) {
		List<Category> allCategories = categoryServices.getAllCategories();
		model.addAttribute("allCategories", allCategories);
		 return "View_Category";
	}
	
	@RequestMapping("/deleteCategory{cid}")
	public String deleteCategoryAdmin(Model model, @PathVariable("cid") int CId) {
		categoryServices.deleteCategoryById(CId);
		return "redirect:/viewCategoryAdmin";
	}

}
