package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Film;
import com.tuanfou.utils.HibernateUtil;

public class FilmDao {
	Session session = null;
	
	/**
	 * ���һ����Ӱ
	 * @param film
	 * @return
	 */
	public boolean addFilm(Film film){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(film);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("��ӵ�Ӱʧ��");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
}
