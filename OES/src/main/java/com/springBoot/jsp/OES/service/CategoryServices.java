package com.springBoot.jsp.OES.service;

import java.util.List;

import com.springBoot.jsp.OES.entity.Category;

public interface CategoryServices {

	List<Category> getAllCategories();

	void deleteCategoryById(int cId);

}
