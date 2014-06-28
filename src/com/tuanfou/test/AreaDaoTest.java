package com.tuanfou.test;

import com.tuanfou.dao.AreaDao;
import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.City;

public class AreaDaoTest {
	public static void main(String[] args) {
		Area area = new Area();
		City city = new City();
		city.setId(2);
		area.setCity(city);
		area.setAreaName("ÇàÉ½Çø");
		AreaDao areaDao = new AreaDao();
		if(areaDao.addArea(area)){
			System.out.println(area.getAreaName());
		}else{
			System.out.println("failed");
		}
		
	}
}
