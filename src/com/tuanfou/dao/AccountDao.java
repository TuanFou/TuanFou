package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Account;
import com.tuanfou.utils.HibernateUtil;

public class AccountDao {
	
	/**
	 * 增加商户
	 * */
	public boolean add(Account account){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(account);
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
	 *更新账户
	 * */
	public boolean update(Account account){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(account);
			session.getTransaction().commit();
			System.out.println("Account Update Success");
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
	
	public float getBalance(int accountId){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Account account = (Account) session.get(Account.class, accountId);
			return account.getBalance();
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
