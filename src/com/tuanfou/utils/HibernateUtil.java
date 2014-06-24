package com.tuanfou.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static SessionFactory sessionFactory = null;//session����
	//��̬��
	static {
		try{
			Configuration cfg = new Configuration().configure();
			sessionFactory = cfg.buildSessionFactory();
		}catch(Exception e){
			System.out.println("�����ػ�����ʧ��");
			e.printStackTrace();
		}
	}
	/*
	 * ��ȡsession
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
	 * ���´����ػ�����
	 */
	private static void rebuildSessionFactory() {
		// TODO Auto-generated method stub
		try{
			Configuration cfg = new Configuration().configure();//����Hibernate�����ļ�
			sessionFactory = cfg.buildSessionFactory();
		}catch(Exception e){
			System.out.println("�����ػ�����ʧ��");
			e.printStackTrace();
		}
	}
	
	/*
	 * ��ȡsessionFactory����
	 * @return sessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	/*
	 * �ر�session
	 * @throws HibernateException
	 */
	public static void closeSession() throws HibernateException{
		Session session = (Session)threadLocal.get();
		threadLocal.set(null);
		if(session != null)
			session.close();
	}
}
