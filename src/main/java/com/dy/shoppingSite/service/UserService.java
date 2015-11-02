package com.dy.shoppingSite.service;

import com.dy.shoppingSite.entity.User;

public interface UserService {

	public void register(User user);
	public User login(String name, String password);
	public boolean isExist(String name);
}
