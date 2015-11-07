package com.dy.shoppingSite.service;

import java.util.List;

import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.entity.Goods;


public interface GoodsService {
	public List<Category> getCategories();
	public void addGoods(Goods goods);
	public List<Goods> getGoodses(Goods goods);
}
