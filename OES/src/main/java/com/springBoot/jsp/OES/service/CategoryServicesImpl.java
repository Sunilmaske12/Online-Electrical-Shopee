package com.springBoot.jsp.OES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.jsp.OES.dao.CategoryRepository;
import com.springBoot.jsp.OES.entity.Category;

@Service
public class CategoryServicesImpl implements CategoryServices {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategoryById(int cId) {
		categoryRepository.deleteById(cId);		
	}

}
