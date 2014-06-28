package com.tuanfou.test;

import com.tuanfou.dao.CityDao;
import com.tuanfou.pojo.City;

public class CityDaoTest {
	public static void main(String[] args) {
		City city  = new City();
		city.setCityName("…œ∫£");
		CityDao cityDao  = new CityDao();
		if(cityDao.addCity(city)){
			System.out.println(city.getCityName());
		}else{
			System.out.println("failed");
		}
		
	}
}
