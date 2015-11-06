package com.dy.shoppingSite.dao;

import java.util.List;

import com.dy.shoppingSite.entity.Category;

public interface CategoryDao {
	public List<Category> getCategories();
	public void addCategory(Category category);
	
}
