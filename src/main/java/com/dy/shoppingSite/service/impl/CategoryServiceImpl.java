package com.dy.shoppingSite.service.impl;

import java.util.List;

import com.dy.shoppingSite.dao.CategoryDao;
import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.service.CategoryService;
import com.dy.shoppingSite.util.MyUntil;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		category.setId(MyUntil.getID());
		category.setGoodsNum(0);
		categoryDao.addCategory(category);
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getCategories();
	}

	
}
