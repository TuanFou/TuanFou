package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.City;
import com.tuanfou.utils.HibernateUtil;

public class CityDao {
	Session session =null;
	
	/**
	 * ���һ������
	 * @param city
	 * @return
	 */
	public boolean addCity(City city){
		boolean res=false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(city);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("��ӳ���ʧ��");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
}
