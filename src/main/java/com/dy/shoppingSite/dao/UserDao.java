package com.dy.shoppingSite.dao;

import com.dy.shoppingSite.entity.User;

public interface UserDao {
	
	public void addUser(User user);
	public User getUserByNameAndPwd(String name, String password);
	public void upadteAvatar(String id, String avatar);
}
