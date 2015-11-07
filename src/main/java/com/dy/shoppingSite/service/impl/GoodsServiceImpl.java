package com.dy.shoppingSite.service.impl;

import java.util.List;

import com.dy.shoppingSite.dao.CategoryDao;
import com.dy.shoppingSite.dao.GoodsDao;
import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.entity.Goods;
import com.dy.shoppingSite.service.CategoryService;
import com.dy.shoppingSite.service.GoodsService;
import com.dy.shoppingSite.util.MyUntil;

public class GoodsServiceImpl implements GoodsService {

	private GoodsDao goodsDao;
	private CategoryService categoryService;
	
	
	public GoodsDao getGoodsDao() {
		return goodsDao;
	}
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public List<Category> getCategories(){
		return categoryService.getCategories();
	}
	

	private CategoryDao categoryDao;
	@Override
	public void addGoods(Goods goods) {
		goods.setId(MyUntil.getID());
		goodsDao.addGoods(goods);
		//这是类别的更新，与商品添加一起完成
		categoryDao.updateGoodsNum(goods.getCategoryId(), 1);
	}
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	
	@Override
	public List<Goods> getGoodses(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodses(goods);
	}
}
