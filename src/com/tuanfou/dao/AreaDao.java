package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Area;
import com.tuanfou.utils.HibernateUtil;

public class AreaDao {
	Session session =null;
	
	/**
	 * ���һ������
	 * @param area
	 * @return
	 */
	public boolean addArea(Area area){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(area);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("��ӵ���ʧ��");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	};
}
