package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.City;
import com.tuanfou.utils.HibernateUtil;

public class CityDao {
	Session session =null;
	
	/**
	 * 添加一个城市
	 * @param city
	 * @return
	 */
	public boolean addCity(City city){
		boolean res=false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(city);
			session.getTransaction().commit();//提交事物
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事物
			System.out.println("添加城市失败");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
}
