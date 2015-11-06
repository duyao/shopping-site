package com.dy.shoppngSite.web;

import java.io.ByteArrayInputStream;

import com.dy.shoppingSite.util.RandomUtils;
import com.opensymphony.xwork2.ActionContext;

public class RandomAction {

	private ByteArrayInputStream image;   
	
	public String execute(){
		RandomUtils randomUtils = RandomUtils.Instance();
		//验证码的图片
		image = randomUtils.getImage();
		//把验证码放入session中
		ActionContext.getContext().getSession().put("vcode", randomUtils.getString());
		System.out.println("vcode"+randomUtils.getString());
		System.out.println("session"+ActionContext.getContext().getSession().get("vcode")
				.toString());
		return "success";
		
	}

	public ByteArrayInputStream getImage() {
		return image;
	}

	public void setImage(ByteArrayInputStream image) {
		this.image = image;
	}

	
}
