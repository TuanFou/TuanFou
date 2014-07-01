package com.tuanfou.service;

import java.util.ArrayList;
import java.util.List;

import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dto.FilmStatusInfo;

public class FilmStatusService {
	
	public List<FilmStatusInfo> getStatusInfo(){
		List<FilmStatusInfo> statusInfo = new ArrayList<FilmStatusInfo>();
		FilmStatusInfo info1 = new FilmStatusInfo();
		FilmStatusInfo info2 = new FilmStatusInfo();
		FilmStatusInfo info3 = new FilmStatusInfo();
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		int TotalNum = groupFilmDao.getTotalGroupFilmNum();
		info1.setStatus("全部");
		info1.setFilmNum(TotalNum);
		statusInfo.add(info1);
		int OnNum = groupFilmDao.getStatusGroupFilmNum(0);
		info2.setStatus("正在上映");
		info2.setFilmNum(OnNum);
		statusInfo.add(info2);
		int number = groupFilmDao.getStatusGroupFilmNum(1);
		info3.setStatus("即将上映");
		info3.setFilmNum(number);
		statusInfo.add(info3);
		return statusInfo;
	}
}
