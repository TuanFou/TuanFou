package com.tuanfou.dao;

import org.hibernate.Session;

import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.utils.HibernateUtil;

public class CinemaDao {
	Session session = null;
	
	/**
	 * ���һ����ӰԺ
	 * @param cinema
	 * @return
	 */
	public boolean addCinema(Cinema cinema){
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
	
	/**
	 * 加载数据库对象，实例化
	 * @param cinemaId
	 * @return
	 */
	public Cinema getCinema(int cinemaId){
		try{
			session = HibernateUtil.getSession();
			Cinema cinema = (Cinema) session.get(Cinema.class, cinemaId);
			return cinema;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	/**
	 * 获得影院的地区对象
	 * @param cinemaId
	 * @return
	 */
	public Area getArea(int cinemaId){
		try{
			session = HibernateUtil.getSession();
			Cinema cinema = (Cinema)session.get(Cinema.class, cinemaId);
			Area area = cinema.getArea();
			return area;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
		
	}
}
