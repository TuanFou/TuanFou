package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.pojo.User;
import com.tuanfou.utils.HibernateUtil;

public class UserDao {
	private Session session = null;
	
	/*
	 * 添加一个用户
	 */
	public boolean addUser(User user){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(user);
			session.getTransaction().commit();//提交事物
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事物
			System.out.println("添加用户失败");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
	/*
	 * 获取用户列表
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUserList(){
		List<User> userList = new ArrayList<User>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from User user";
			Query q = session.createQuery(hql);
			userList = q.list();
		}catch(Exception e){
			System.out.println("查询失败");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return userList;	
	}
}
