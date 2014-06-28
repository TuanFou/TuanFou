package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

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
	
	@SuppressWarnings("unchecked")
	public List<Message> findReceiveMsg(int type,int receiverId){
		Session session = null;
		List<Message> list = new ArrayList<Message>();
		try{
			session = HibernateUtil.getSession();
			String hql = "From Message message where message.receiverId=:receiverId and message.type=:type";
			Query query =  session.createQuery(hql);
			query.setParameter("receiverId", receiverId);
			query.setParameter("type", type);
			list = query.list();
			return list;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}

}
