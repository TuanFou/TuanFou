package com.tuanfou.service;

import java.util.List;

import com.tuanfou.dao.AccountDao;
import com.tuanfou.dao.UserDao;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.pojo.Account;
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
	/*
	 * 获取用户个人详细信息
	 */
	public User getUserInfo(int id){
		UserDao userDao = new UserDao();
		User user = userDao.getUser(id);
		return user;
	}
	/*
	 * 根据用户id获取用户想看的电影信息
	 */
	public List<MyHeartGroupFilmInfo> getHeartFilmByUserId(int id){
		UserDao  userDao = new UserDao();
		List<MyHeartGroupFilmInfo> list = userDao.getHeartGroupFilms(id);
		return list;
	}
	/*
	 * 为新用户添加一个账户
	 */
	public boolean addAccount(Account account){
		AccountDao accountrDao = new AccountDao();
		if(accountrDao.add(account)){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 通过用户id获取账户余额
	 */
	public float getBalance(int userId){
		UserDao userDao = new UserDao();
		Account account = userDao.getAccount(userId);
		return account.getBalance();
	}
}
