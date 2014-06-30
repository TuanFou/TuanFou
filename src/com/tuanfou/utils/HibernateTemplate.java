package com.tuanfou.utils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class HibernateTemplate {
	private static Session session = null;
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> executeQuery(String hql,int firstResult,int maxResult){
		List<T> list = new ArrayList<T>();
		try{
			session = HibernateUtil.getSession();
			Query q = session.createQuery(hql);
			q.setFirstResult(firstResult);
			q.setMaxResults(maxResult);
			list  = q.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return list;
		
	}
}
