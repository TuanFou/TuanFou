package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Admin;
import com.tuanfou.utils.HibernateUtil;

public class AdminDao {
	/**
	 * 更新管理员信息
	 * */
	public boolean update(Admin admin){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(admin);
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
	 * 增加管理员信息
	 * */
	public boolean add(Admin admin){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(admin);
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
	
	public Admin getAdmin(int adminId){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Admin admin = (Admin)session.get(Admin.class, adminId);
			return admin;
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
