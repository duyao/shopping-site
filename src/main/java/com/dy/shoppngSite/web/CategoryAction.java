package com.dy.shoppngSite.web;

import java.util.List;

import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.service.CategoryService;

public class CategoryAction {
	private CategoryService categoryService;
	private Category category;

	public String add() {
		categoryService.addCategory(category);
		return "oprsuc";
	}
	
	
	private List<Category> categories;
	public String list(){
		categories = categoryService.getCategories();
		return "list";
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
