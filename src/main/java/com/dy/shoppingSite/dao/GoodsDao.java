package com.dy.shoppingSite.dao;

import java.util.List;

import com.dy.shoppingSite.entity.Goods;

public interface GoodsDao {

	public void addGoods(Goods goods);
	public List<Goods> getGoodses(Goods goods);
}
