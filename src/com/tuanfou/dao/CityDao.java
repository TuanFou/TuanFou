package com.tuanfou.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
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
	
	/**
	 * 获得城市列表
	 * @param city
	 * @return
	 */
	public Map<Integer,String> getCities(){
		Map<Integer,String> cities = new HashMap<Integer,String>();
		try{
			session = HibernateUtil.getSession();
			String hql = "From City";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<City> cityList = query.list();
			Iterator<City> it = cityList.iterator();
			while(it.hasNext()){
				City city = it.next();
				int cityId = city.getId();
				String cityName = city.getCityName();
				cities.put(cityId, cityName);
			}
			return cities;
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
