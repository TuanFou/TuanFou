package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.utils.HibernateUtil;

public class GroupFilmDao {
	private Session session = null;
	
	public boolean addGroupFilm(GroupFilm groupFilm){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(groupFilm);
			session.getTransaction().commit();
			res = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
}
