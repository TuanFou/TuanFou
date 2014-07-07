package com.tuanfou.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
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
		Gson gson = new Gson();
		String str = gson.toJson(cities);
		System.out.println(str);
	}
}
