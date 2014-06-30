package com.tuanfou.test;

import java.util.Iterator;
import java.util.List;


import com.tuanfou.dao.AreaDao;
import com.tuanfou.dto.AreaInfo;
import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.City;
import com.tuanfou.service.AreaService;

public class AreaDaoTest {
	public static void main(String[] args) {

		/*Area area = new Area();
		City city = new City();
		city.setId(2);
		area.setCity(city);
		area.setAreaName("��ɽ��");
		AreaDao areaDao = new AreaDao();
		if(areaDao.addArea(area)){
			System.out.println(area.getAreaName());
		}else{
			System.out.println("failed");
		}*/
		
		AreaDao areaDao = new AreaDao();
		List<Area> areaList = areaDao.getAreaList(2);
		Iterator<Area> it = areaList.iterator();
		while(it.hasNext())
		{
			Area area = it.next();
			System.out.println("AreaName:"+area.getAreaName());
		}
		
		AreaService areaService = new AreaService();
		List<AreaInfo> areaInfoList = areaService.getAreaInfoList(2);
		Iterator<AreaInfo> It = areaInfoList.iterator();
		while(It.hasNext()){
			AreaInfo areaInfo = It.next();
			System.out.println("AreaName:"+areaInfo.getAreaName()+"	Number:"+areaInfo.getFilmNumber());
		}
		
	}
}
