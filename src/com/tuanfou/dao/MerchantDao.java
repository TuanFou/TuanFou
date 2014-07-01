package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Merchant;
import com.tuanfou.utils.HibernateUtil;

public class MerchantDao {
	Session session = null;
	
	/**
	 * ���һ���̼�
	 * @param merchant
	 * @return
	 */
	public boolean addMerchant(Merchant merchant){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(merchant);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("����̼�ʧ��");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
	
	public boolean update(Merchant merchant){
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.update(merchant);
			session.getTransaction().commit();//�ύ����
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			e.printStackTrace();
			return false;
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	/**
	 * 实例化，加载数据库对象
	 * @param merchantId
	 * @return
	 */
	public Merchant getMerchant(int merchantId){
		try{
			session = HibernateUtil.getSession();
			Merchant merchant = (Merchant) session.get(Merchant.class, merchantId);
			return merchant;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	public Set<Cinema> getCinema(int merchantId){
		Set<Cinema> cinemas = new HashSet<Cinema>();
		try{
			session = HibernateUtil.getSession();
			Merchant merchant = (Merchant) session.get(Merchant.class, merchantId);
			Iterator<Cinema> it = merchant.getCinemas().iterator();
			while(it.hasNext()){
				Cinema cinema = it.next();
				cinemas.add(cinema);
			}
			return cinemas;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
		/*
	 * 获取商家列表
	 */
	public List<Merchant> getMerchantList(){
		List<Merchant> merchantList = new ArrayList<Merchant>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from Merchant merchant";
			Query q = session.createQuery(hql);
			merchantList = q.list();
		}catch(Exception e){
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return merchantList;	
	}
}
