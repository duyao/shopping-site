package com.dy.shoppingSite.service.impl;

import java.util.HashMap;
import java.util.List;

import com.dy.shoppingSite.dao.CategoryDao;
import com.dy.shoppingSite.dao.GoodsDao;
import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.entity.Goods;
import com.dy.shoppingSite.entity.PageBean;
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
	
	//通过分页查询
	@Override
	public PageBean<Goods> listGoodsByPage(Goods goods, int page) {
		// TODO Auto-generated method stub
		//设定好每页显示多少条
		int pageSize = 3;
		HashMap< String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("goods", goods);
		//limit a,b,a是该页第一条-1，b是该页显示几条
		//mysql查询的两个参数，一个是pageSize
		hashMap.put("pageSize", pageSize);
		//mysql查询的两个参数，另一个是序号，这里设置为
		int pageNo = (page- 1)*pageSize;
		hashMap.put("pageNo", pageNo);
		
		//将pageBean的内容封装好
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setData(goodsDao.listGoodsByPage(hashMap));
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		pageBean.setPageNo(pageNo);
		int totalNum = goodsDao.getTotalNum(goods);
		pageBean.setTotalNum(totalNum);
		int totalPage = totalNum % pageSize == 0? totalNum/pageSize: (totalNum/pageSize + 1);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
	
	@Override
	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		//这里更新要先将beforeGoods拿来，然后把新的goods中属性付给beforeGoods
		//因为goods中不一定所有属性都进行更新，会产生空值，导致出错
		Goods beforeGoods = goodsDao.getGoodsById(goods.getId());
		beforeGoods.setCategory(goods.getCategory());
		beforeGoods.setCategoryId(goods.getCategoryId());
		beforeGoods.setDescription(goods.getDescription());
		beforeGoods.setGoodsNo(goods.getGoodsNo());
		beforeGoods.setName(goods.getName());
		beforeGoods.setPrice1(goods.getPrice1());	
		beforeGoods.setPrice2(goods.getPrice2());
		beforeGoods.setStock(goods.getStock());
		beforeGoods.setThumbnail(goods.getThumbnail());
		
		goodsDao.updateGoods(beforeGoods);
		

		
		
	}
	@Override
	public Goods getGoodsById(String id) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsById(id);
	}
	
	@Override
	public void delGoods(String id) {
		// TODO Auto-generated method stub
		goodsDao.delGoods(id);
	}
	@Override
	public List<Goods> getGoodsByCateId(String categoryId) {
		// TODO Auto-generated method stub
		//每页显示6条商品
		return goodsDao.getGoodsByCateId(categoryId, 6);
	}
	@Override
	public List<Goods> getGoodsByIds(String... ids) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByIds(ids);
	}
	
	
	
}
