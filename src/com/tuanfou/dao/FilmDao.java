package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.Tag;
import com.tuanfou.utils.HibernateUtil;

public class FilmDao {
	Session session = null;
	
	/**
	 * 添加一个电�
	 * @param film
	 * @return
	 */
	public boolean addFilm(Film film){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(film);
			session.getTransaction().commit();//提交事务
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事务
			System.out.println("添加电影失败");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}

	
	//电影总数
	public int getTotalFilmsNum(){
		try{
			session = HibernateUtil.getSession();
			String hql = "Select count(*) from Film";
			Query query = session.createQuery(hql);
			return ((Long)query.uniqueResult()).intValue();
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		finally{
			HibernateUtil.closeSession();
		}		
	}
}
