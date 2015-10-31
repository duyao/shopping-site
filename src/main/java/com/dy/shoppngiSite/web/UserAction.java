package com.dy.shoppngiSite.web;

import com.dy.shoppingSite.entity.User;
import com.dy.shoppingSite.service.UserService;

public class UserAction {
	private UserService userService;
	private User user;

	public String reg() {
		userService.register(user);
		return "regsuc";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
