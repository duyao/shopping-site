package com.dy.shoppingSite.service.impl;


import com.dy.shoppingSite.dao.UserDao;
import com.dy.shoppingSite.entity.User;
import com.dy.shoppingSite.service.UserService;
import com.dy.shoppingSite.util.MyUntil;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		System.out.println("fdsadsafd\n");
		System.out.println(user.toString());
		user.setId(MyUntil.getID());
		user.setRegTime(MyUntil.getNowTime());
		user.setRole("u");
		System.out.println("fdsadsafd\n");
		System.out.println(user.toString());
		userDao.addUser(user);
	}

	@Override
	public User login(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean isExist(String name) {
		// TODO Auto-generated method stub
		int num = userDao.getNumByName(name);
		if(num == 0){
			return false;
		}
		return true;
	}

}
