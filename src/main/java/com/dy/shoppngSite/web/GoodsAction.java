package com.dy.shoppngSite.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.entity.Goods;
import com.dy.shoppingSite.entity.User;
import com.dy.shoppingSite.service.GoodsService;
import com.dy.shoppingSite.util.MyUntil;
import com.opensymphony.xwork2.ActionContext;

public class GoodsAction {
	private GoodsService goodsService;
	private Goods goods;
	
	//显示页面的所有商品
	private List<Goods> goodses;
	public String list(){
		categories = goodsService.getCategories();
		goodses = goodsService.getGoodses(goods);
		return "list";
	}

	// 类型的列表，显示在添加中的下拉菜单
	private List<Category> categories;
	// 商品型号，系统自动生成
	private String goodsNo;

	public String initadd() {
		categories = goodsService.getCategories();
		goodsNo = "gs" + MyUntil.getGoodNo();
		return "initadd";
	}

	// 商品缩略图上传的属性
	private File thumbnail;
	private String thumbnailFileName;

	public String add() {
		
		// 得到文件存放的绝对地址
		String path = ServletActionContext.getServletContext().getRealPath("/goodsImages");
		//存放的文件名
		String saveName = "";
		if (thumbnail != null) {
			// 得到才上传文件的后缀名
			String suffix = thumbnailFileName.substring(thumbnailFileName.lastIndexOf("."));
			// 得到新的文件，与上传文件相同，文件名是随机id+后缀名
			saveName = MyUntil.getID() + suffix;
			File saveFile = new File(new File(path), saveName);
			try {
				if (!saveFile.getParentFile().exists()) {
					saveFile.getParentFile().mkdir();
				}
				// 把上传文件拷贝到服务器端/goodsImages
				FileUtils.copyFile(thumbnail, saveFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 存放到数据库中
			goods.setThumbnail("goodsImages/" + saveName);
		}
		
		goodsService.addGoods(goods);
		return "addsuc";
		
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public File getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(File thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getThumbnailFileName() {
		return thumbnailFileName;
	}

	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getGoodses() {
		return goodses;
	}

	public void setGoodses(List<Goods> goodses) {
		this.goodses = goodses;
	}

}
