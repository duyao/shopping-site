package com.dy.shoppngSite.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dy.shoppingSite.entity.Category;
import com.dy.shoppingSite.entity.Goods;
import com.dy.shoppingSite.entity.PageBean;
import com.dy.shoppingSite.service.GoodsService;
import com.dy.shoppingSite.util.MyUntil;

public class GoodsAction {
	private GoodsService goodsService;
	private Goods goods;
	
	public String del(){
		goodsService.delGoods(goods.getId());
		return "delsuc";
	}

	public String update() {
		//用户传入了新的图片
		if (thumbnail != null) {
			// 得到文件存放的绝对地址，没有到、goodsImg，数据库中已经存，后面删除只需要知道前面的
			String path = ServletActionContext.getServletContext().getRealPath("/");
			// 存放的文件名
			String saveName = "";
			// 得到才上传文件的后缀名
			String suffix = thumbnailFileName.substring(thumbnailFileName
					.lastIndexOf("."));
			// 得到新的文件，与上传文件相同，文件名是随机id+后缀名
			saveName = MyUntil.getID() + suffix;
			File saveFile = new File(new File(path + "/goodsImages"), saveName);
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
			//删除原有文件
			new File(path + "/" + goods.getThumbnail()).delete();
			// 存放到数据库中
			goods.setThumbnail("goodsImages/" + saveName);
		}
		System.out.println(goods.toString());
		goodsService.updateGoods(goods);
		return "upsuc";
	}

	public String initUpdate() {

		// 更新时还是要取得所有的分类，这样才能在下拉菜单中选择
		categories = goodsService.getCategories();
		goods = goodsService.getGoodsById(goods.getId());
		return "update";
	}

	// 用于分页显示内容
	private PageBean<Goods> pageBean;
	// 由前端给出的显示要查询的页数,分页就靠这个page
	private int page;

	public String listGoodsByPage() {
		// goods信息返回页面，是为了显示查询条件
		categories = goodsService.getCategories();
		if (page == 0) {
			page = 1;
		}

		pageBean = goodsService.listGoodsByPage(goods, page);

		return "list";

	}

	// 显示页面的所有商品
	private List<Goods> goodses;

	public String list() {
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
		String path = ServletActionContext.getServletContext().getRealPath(
				"/goodsImages");
		// 存放的文件名
		String saveName = "";
		if (thumbnail != null) {
			// 得到才上传文件的后缀名
			String suffix = thumbnailFileName.substring(thumbnailFileName
					.lastIndexOf("."));
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

	public PageBean<Goods> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Goods> pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
