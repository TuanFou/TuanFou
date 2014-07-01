package com.tuanfou.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.tuanfou.dao.CityDao;
import com.tuanfou.pojo.City;

public class CityDaoTest {
	public static void main(String[] args) {
		//City city  = new City();
		//city.setCityName("�Ϻ�");
		CityDao cityDao  = new CityDao();
		//if(cityDao.addCity(city)){
			//System.out.println(city.getCityName());
		//}else{
			//System.out.println("failed");
		//}
		Map<Integer,String> cities = cityDao.getCities();
		Iterator<Entry<Integer, String>> it = cities.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, String> city = (Map.Entry<Integer, String>)it.next();
		System.out.println("CityID:"+city.getKey()+"	cityName:"+city.getValue());
		}
	}
}
