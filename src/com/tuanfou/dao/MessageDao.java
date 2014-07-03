package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;

import com.tuanfou.pojo.Message;
import com.tuanfou.utils.HibernateTemplate;
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
	
	/**
	 * 获得所有受到的信息内容
	 * */
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
	
	/**
	 * @author yogiman
	 * @param userId
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<Message> getReceivedMessage(int userId,int firstResult,int maxResult){
		String hql ="from Message message where message.receiverId = ";
		Integer integer = userId;
		String temp = integer.toString();
		hql += temp;
		List<Message> messages = new HibernateTemplate().executeQuery(hql, firstResult, maxResult);
		return messages;
	}
	
	public List<Message> getSentMessages(int userId,int firstResult,int maxResult){
		String hql ="from Message message where message.senderId = ";
		Integer integer = userId;
		String temp = integer.toString();
		hql += temp;
		List<Message> messages = new HibernateTemplate().executeQuery(hql, firstResult, maxResult);
		return messages;
	}
}
