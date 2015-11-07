package com.dy.shoppingSite.dao;

import java.util.List;

public class PageBean<T> {
	//数据
	private List<T> data;
	//设置每页显示多少条，固定的
	private int pageSize;
	//当前页的记录的标号
	private int pageNo;
	//总页数
	private int totalPage;
	//当前页数
	private int page;
	//总的条数，即一共多少条记录
	private int totalNum;
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	

}
