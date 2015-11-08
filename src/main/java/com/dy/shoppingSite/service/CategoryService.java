package com.dy.shoppingSite.service;

import java.util.List;

import com.dy.shoppingSite.entity.Category;

public interface CategoryService {
	
	public void addCategory(Category category);
	public List<Category> getCategories();
	/**
	 * 为index设计的得到商品类别的方法，该方法还得到了该商品类别中所有物品
	 */
	public List<Category> getCategoriesForIndex();
	
}
