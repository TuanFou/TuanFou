package com.tuanfou.dao;

import org.hibernate.Query;
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
	
	//电影总数
	public int getTotalFilmsNum(){
		try{
			session = HibernateUtil.getSession();
			String hql = "Select count(*) from Film";
			Query query = session.createQuery(hql);
			return ((Long)query.uniqueResult()).intValue();
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
