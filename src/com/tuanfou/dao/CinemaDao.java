package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Cinema;
import com.tuanfou.utils.HibernateUtil;

public class CinemaDao {
	Session session = null;
	
	/**
	 * ���һ����ӰԺ
	 * @param cinema
	 * @return
	 */
	public boolean addFilm(Cinema cinema){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(cinema);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("���ӰԺʧ��");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
}
