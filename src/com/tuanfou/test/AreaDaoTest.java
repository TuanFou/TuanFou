package com.tuanfou.test;

import com.tuanfou.dao.AreaDao;
import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.City;

public class AreaDaoTest {
	public static void main(String[] args) {
		addAreaTest();
	}
	
	public static void addAreaTest(){
		Area area = new Area();
		City city = new City();
		city.setId(6);
		area.setCity(city);
		area.setAreaName("hongshan");
		AreaDao areaDao = new AreaDao();
		areaDao.addArea(area);
		System.out.println(area.getAreaName());
	}
}
