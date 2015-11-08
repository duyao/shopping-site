package com.dy.shoppingSite.service.impl;

import java.util.List;

import com.dy.shoppingSite.dao.CategoryDao;
import com.dy.shoppingSite.dao.GoodsDao;
import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.service.CategoryService;
import com.dy.shoppingSite.util.MyUntil;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao;
	private GoodsDao goodsDao;

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

	@Override
	public List<Category> getCategoriesForIndex() {
		// TODO Auto-generated method stub
		List<Category> categories = categoryDao.getCategories();
		for (Category category : categories) {
			category.setGoodses(goodsDao.getGoodsByCateId(category.getId(), 4));
		}
		return categories;
	}

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	
}
