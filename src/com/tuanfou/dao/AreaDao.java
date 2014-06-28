package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Area;
import com.tuanfou.utils.HibernateUtil;

public class AreaDao {
	Session session =null;
	
	/**
	 * 添加一个地区
	 * @param area
	 * @return
	 */
	public boolean addArea(Area area){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(area);
			session.getTransaction().commit();//提交事物
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事物
			System.out.println("添加地区失败");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	};
}
