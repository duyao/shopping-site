package com.dy.shoppingSite.service;

import java.util.List;

import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.entity.Goods;
import com.dy.shoppingSite.entity.PageBean;


public interface GoodsService {
	public List<Category> getCategories();
	public void addGoods(Goods goods);
	public List<Goods> getGoodses(Goods goods);
	public PageBean<Goods> listGoodsByPage(Goods goods,int page);
	public void updateGoods(Goods goods);
	public Goods getGoodsById(String id);
	public void delGoods(String id);
	
	public List<Goods> getGoodsByCateId(String categoryId);
	//string...表示变长数组
	public List<Goods> getGoodsByIds(String... ids);
}
