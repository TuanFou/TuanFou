package com.tuanfou.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static SessionFactory sessionFactory = null;//session工厂
	//静态块
	static {
		try{
			Configuration cfg = new Configuration().configure();
			sessionFactory = cfg.buildSessionFactory();
		}catch(Exception e){
			System.out.println("创建回话工厂失败");
			e.printStackTrace();
		}
	}
	/*
	 * 获取session
	 * @return session
	 * @throws HibernateException
	 */
	public static Session getSession() throws HibernateException{
		Session session = (Session)threadLocal.get();
		if(session == null || !session.isOpen()){
			if(sessionFactory == null){
				rebuildSessionFactory();
		    } 
			session = (sessionFactory!=null) ?sessionFactory.openSession() : null;
			threadLocal.set(session);
		}
		return session;
	}
	/*
	 * 重新创建回话工厂
	 */
	private static void rebuildSessionFactory() {
		// TODO Auto-generated method stub
		try{
			Configuration cfg = new Configuration().configure();//加载Hibernate配置文件
			sessionFactory = cfg.buildSessionFactory();
		}catch(Exception e){
			System.out.println("创建回话工厂失败");
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取sessionFactory对象
	 * @return sessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	/*
	 * 关闭session
	 * @throws HibernateException
	 */
	public static void closeSession() throws HibernateException{
		Session session = (Session)threadLocal.get();
		threadLocal.set(null);
		if(session != null)
			session.close();
	}
}
