package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Cinema;
import com.tuanfou.utils.HibernateUtil;

public class CinemaDao {
	Session session = null;
	
	/**
	 * 添加一个电影院
	 * @param cinema
	 * @return
	 */
	public boolean addCinema(Cinema cinema){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(cinema);
			session.getTransaction().commit();//提交事物
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事物
			System.out.println("添加影院失败");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
}
