package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Message;
import com.tuanfou.utils.HibernateUtil;

public class MessageDao {
	
	public boolean add(Message message){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(message);
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
