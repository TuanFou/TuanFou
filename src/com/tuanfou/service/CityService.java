package com.tuanfou.service;

import java.util.Map;

import com.tuanfou.dao.CityDao;

public class CityService {
	public Map<Integer,String>listCities(){
		CityDao cityDao = new CityDao();
		Map<Integer,String> cityList = cityDao.getCities();
		return cityList;
	}
}
