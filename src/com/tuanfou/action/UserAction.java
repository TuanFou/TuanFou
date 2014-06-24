package com.tuanfou.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.pojo.User;
import com.tuanfou.service.UserService;

public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 登录操作
	 * @return 是否成功
	 */
	private User user;
	private List<User> userList;
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/*
	 * 登录用户
	 */
	public String login(){
		UserService service = new UserService();
		if(service.addUser(user)){
			return SUCCESS;
		}else{
			return ERROR;
		}

	}
	public String regist(){
		return SUCCESS;
	}
	
	/*
	 * 获取用户列表
	 */
	public String listUsers(){
		UserService service = new UserService();
		userList = service.getUserList();
		return SUCCESS;
	}
}
