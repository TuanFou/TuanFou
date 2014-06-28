package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Tag;
import com.tuanfou.utils.HibernateUtil;

public class TagDao {
	
	public boolean add(Tag tag){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(tag);
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}

}
