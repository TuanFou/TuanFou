package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
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
	}
	
	/*
	 * 获得地区列表
	 */
	@SuppressWarnings("unchecked")
	public List<Area> getAreaList(int cityId){
		List<Area> areaList = new ArrayList<Area>();
		try{
			session = HibernateUtil.getSession();
			String hql = "From Area area where area.city.id = :cityId";
			Query query = session.createQuery(hql);
			query.setParameter("cityId", cityId);
			Iterator<Area> it = query.list().iterator();
			
			while(it.hasNext())
			{
				Area area = it.next();
				//if(area.getCity().getId() == cityId)
				areaList.add(area);		
			}
			
			return areaList;			
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
