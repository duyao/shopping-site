package com.dy.shoppingSite.dao;

import java.util.HashMap;
import java.util.List;

import com.dy.shoppingSite.entity.Goods;

public interface GoodsDao {

	public void addGoods(Goods goods);
	//outOfDate-得到商品，包括搜索条件，但是没有分页
	public List<Goods> getGoodses(Goods goods);
	//通过分页得到商品，包括搜索条件
	//hashmap放参数，有goods(含有查询条件)和pageSize和curPage
	public List<Goods> listGoodsByPage(HashMap<String, Object> hashMap);
	//得到总条数
	public int getTotalNum(Goods goods);
}
