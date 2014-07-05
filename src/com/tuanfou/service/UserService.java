package com.tuanfou.service;

import java.util.List;
import java.util.Set;

import com.tuanfou.dao.UserDao;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.pojo.Comment;
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
	 * 获取用户所有评论
	 */
	public Set<Comment> getUserComments(int userId){
		UserDao userDao = new UserDao();
		Set<Comment> userComments = userDao.getUserComments(userId);
		return userComments;
	}
}
