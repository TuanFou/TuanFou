package com.tuanfou.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tuanfou.dao.AreaDao;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dto.AreaInfo;
import com.tuanfou.pojo.Area;

/**
 * 获取首页部分地区导航信息
 * @author LN
 *
 */
public class AreaService {

	public List<AreaInfo> getAreaInfoList(int cityId){
		AreaDao areaDao = new AreaDao();
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		List<Area> areaList = areaDao.getAreaList(cityId);
		List<AreaInfo> areaInfoList = new ArrayList<AreaInfo>();
		
		Iterator<Area> it = areaList.iterator();
		while(it.hasNext()){
			Area area = it.next();
			int areaId = area.getId();
			int number = groupFilmDao.getAreaGroupFilmNum(areaId);
			AreaInfo areaInfo = new AreaInfo();
			areaInfo.setAreaId(areaId);
			areaInfo.setAreaName(area.getAreaName());
			areaInfo.setFilmNumber(number);
			areaInfoList.add(areaInfo);
		}
		return areaInfoList;		
	}
}
