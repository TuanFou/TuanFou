package com.tuanfou.service;

import java.util.List;

import com.tuanfou.dao.UserDao;
import com.tuanfou.pojo.User;

public class UserService {
	/*
	 * ���һ���û�
	 */
	public boolean addUser(User user){
		UserDao userDao = new UserDao();
		if(userDao.addUser(user)){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * ��ȡ�û��б�
	 */
	public List<User> getUserList(){
		UserDao userDao = new UserDao();
		return userDao.getUserList();
	}
}
