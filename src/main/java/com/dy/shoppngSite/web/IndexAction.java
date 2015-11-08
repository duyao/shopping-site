package com.dy.shoppngSite.web;

import java.util.List;

import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.service.CategoryService;

public class IndexAction {
	private CategoryService categoryService;
	private List<Category> categories;
	public String execute(){
		System.out.println("in index");
		categories = categoryService.getCategoriesForIndex();
		
		return "index";
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
