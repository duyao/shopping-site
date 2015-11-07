package com.dy.shoppingSite.entity;

public class Goods {

	private String id;
	private String goodsNo;
	private String name;
	private String categoryId;
	private Float price1;
	private Float price2;
	private int stock;
	private String thumbnail;
	private String description;
	
	//一对多映射
	private Category category;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Float getPrice1() {
		return price1;
	}
	public void setPrice1(Float price1) {
		this.price1 = price1;
	}
	public Float getPrice2() {
		return price2;
	}
	public void setPrice2(Float price2) {
		this.price2 = price2;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}


}
