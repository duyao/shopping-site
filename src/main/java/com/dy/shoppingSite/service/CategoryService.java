package com.dy.shoppingSite.service;

import java.util.List;

import com.dy.shoppingSite.entity.Category;

public interface CategoryService {
	
	public void addCategory(Category category);
	public List<Category> getCategories();

}
