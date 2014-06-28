package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Merchant;
import com.tuanfou.utils.HibernateUtil;

public class MerchantDao {
	Session session = null;
	
	/**
	 * 添加一个商家
	 * @param merchant
	 * @return
	 */
	public boolean addMerchant(Merchant merchant){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(merchant);
			session.getTransaction().commit();//提交事物
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事物
			System.out.println("添加商家失败");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
}
