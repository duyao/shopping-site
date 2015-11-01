package com.dy.shoppngSite.web;

import org.apache.struts2.ServletActionContext;

import com.dy.shoppingSite.entity.User;
import com.dy.shoppingSite.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction {
	private UserService userService;
	private User user;

	public String reg() {
		// The name attribute's value also has a reference to an object.
		// Note we have a Struts 2 textfield for each instance field of the
		// class Person. Remember that Person class's age attribute is of type
		// integer. All form field input values are Strings. Struts 2 will
		// automatically convert the String value ("25") the user entered for
		// the age form field to 25 when calling the setAge method of object
		// personBean.
		System.out.println("reg+user");
		//System.out.println("uu"+uu.getName()+uu.getPassword());
		String nameString = ActionContext.getContext().getValueStack().findString("name");
		System.out.println(nameString);
		System.out.println(user.getName()+user.getPassword());
		userService.register(user);
		return "regsuc";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
