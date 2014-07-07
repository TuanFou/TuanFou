package com.tuanfou.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.tuanfou.dao.AccountDao;
import com.tuanfou.dao.ComplaintDao;
import com.tuanfou.dao.UserDao;
import com.tuanfou.dto.ComplaintInfo;
import com.tuanfou.dto.MyCommentInfo;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.pojo.Account;
import com.tuanfou.pojo.Comment;
import com.tuanfou.pojo.Complaint;
import com.tuanfou.pojo.User;
import com.tuanfou.utils.HibernateUtil;

public class UserService {
	/*
	 * ���һ���û�
	 */
	public boolean addUser(User user){
		int res = 1;
		try{
			List<User> userList = getUserList();
			Iterator<User> itUser =userList.iterator();	
			while(itUser.hasNext())
			{			
				if(itUser.next().getUserName().equals(user.getUserName())){
					res = -1;
				}
			}
			if(res==1){
				Account account = new Account();
				AccountDao accountDao = new AccountDao();
				account.setBalance(100);
				accountDao.add(account);
				user.setAccount(account);
				UserDao userDao = new UserDao();
				if(userDao.addUser(user)){
					  return true;
				}
				else{
					return false;
				}
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
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
	 * 通过用户id获取账户余额
	 */
	public float getBalance(int userId){
		UserDao userDao = new UserDao();
		Account account = userDao.getAccount(userId);
		return account.getBalance();
	}
	/*

	 *查找用户返回用户id
	 */
	public int findUser(String userName,String password ){
		UserDao userDao = new UserDao();
		return userDao.findUser(userName, password);
	}
	/*
	 * 获取用户评论
	 */
	public Set<MyCommentInfo> getMyComments(int userId){
		UserDao userDao = new UserDao();
		Set<MyCommentInfo> comments = userDao.getUserComments(userId);
		//排序函数
		return comments;
	}
	/*
	 * 获取用户投诉,未写完。。。。。
	 */
	public List<ComplaintInfo> getMyComplaints(int userId){
		ComplaintDao complaintDao = new ComplaintDao();
		List<ComplaintInfo> complaints = complaintDao.getUserComplaints(userId, 1, 10);
		return complaints;
	}
}
