package com.tuanfou.dao;

import org.hibernate.Session;

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
	

}
