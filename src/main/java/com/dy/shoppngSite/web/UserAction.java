package com.dy.shoppngSite.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dy.shoppingSite.entity.User;
import com.dy.shoppingSite.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private UserService userService;
	private User user;

	//页面显示的用户输入验证码
	private String captcha;
	//错误提示信息
	private String msg;
	public String adminLogin() {
		User u = userService.login(user.getName(), user.getPassword());
		String vcode = ActionContext.getContext().getSession().get("vcode")
				.toString();
		//System.out.println(u.toString());
		if (!vcode.equals(captcha)) {
			msg = "验证码错误";
			return "adminlogin";
		}
		if (u == null) {
			msg = "用户名或密码错误";
			return "adminlogin";
		}
		if(!u.getRole().equals("a")){
			msg = "权限不足";
			return "adminlogin";
		}
		Map<String, Object> map = ActionContext.getContext().getSession();
		// header.jsp中取出session的user
		map.put("user", u);
		return "adminindex";

	}

	// 上传头像
	// struts2对于文件上传已经规定好了属性
	// setX(File file),setXFileName(String fileName),setXContentType(String
	// contentType)
	private File avatar;
	private String avatarFileName;

	public String login() {
		User u = userService.login(user.getName(), user.getPassword());
		if (u == null) {
			return "loginfail";
		} else {
			Map<String, Object> map = ActionContext.getContext().getSession();
			// header.jsp中取出session的user
			map.put("user", u);
			return "loginsuc";
		}
	}

	public String logout() {
		ActionContext.getContext().getSession().clear();
		return "logout";
	}

	// 使用ajax和jquery来实现，需要服务器端返回一个无参数的函数
	// 参数传递使用response
	public void isExist() {
		boolean b = userService.isExist(user.getName());
		try {
			PrintWriter writer = ServletActionContext.getResponse().getWriter();
			writer.print(b);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 上传用户头像
	public String uploadAvatar() {
		String userId = ((User) ActionContext.getContext().getSession()
				.get("user")).getId();
		// 得到文件存放的绝对地址
		String path = ServletActionContext.getServletContext().getRealPath(
				"/userAvatars");
		System.out.println(path);
		if (avatar != null) {
			// 得到才上传文件的后缀名
			String suffix = avatarFileName.substring(avatarFileName
					.lastIndexOf("."));
			System.out.println(userId + suffix);
			// 得到新的文件，与上传文件相同，文件名是id+后缀名
			File saveFile = new File(new File(path), userId + suffix);
			try {
				if (!saveFile.getParentFile().exists()) {
					saveFile.getParentFile().mkdir();
				}
				// 把上传文件拷贝到服务器端/avatar
				FileUtils.copyFile(avatar, saveFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 存放到数据库中
			userService.upadteAvatar(userId, "userAvatars/" + userId + suffix);
			// 更新session
			((User) ActionContext.getContext().getSession().get("user"))
					.setAvatar("userAvatars/" + userId + suffix);
			return "usercenter";

		}
		return path;

	}

	public String reg() {
		// The name attribute's value also has a reference to an object.
		// Note we have a Struts 2 textfield for each instance field of the
		// class Person. Remember that Person class's age attribute is of type
		// integer. All form field input values are Strings. Struts 2 will
		// automatically convert the String value ("25") the user entered for
		// the age form field to 25 when calling the setAge method of object
		// personBean.
		System.out.println("reg+user");
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

	public File getAvatar() {
		return avatar;
	}

	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
