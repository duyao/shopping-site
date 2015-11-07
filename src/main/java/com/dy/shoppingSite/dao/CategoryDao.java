package com.dy.shoppingSite.dao;

import java.util.List;

import com.dy.shoppingSite.entity.Category;

public interface CategoryDao {
	public List<Category> getCategories();
	public void addCategory(Category category);
	//这是类别的更新，与商品添加一起完成,在goods_add中调用
	//不需要在categoryService中调用，由goodsService完成调用
	public void updateGoodsNum(String id, int num);
}
