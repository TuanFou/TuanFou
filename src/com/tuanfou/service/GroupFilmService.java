package com.tuanfou.service;

import java.util.ArrayList;
import java.util.List;

import com.tuanfou.dao.CommentDao;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dto.FilmStatusInfo;
import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.dto.GroupFilmDetailedInfo;

public class GroupFilmService {
	/*
	 * ָ��ҳ���ÿҳ��ʾ��������ظ��
	 */
	public List<GroupFilmBriefInfo> loadGroupFilmsBriefInfo(int page,int pageSize){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		int firstResult = (page-1)*pageSize;
		List<GroupFilmBriefInfo> groupFilms = groupFilmDao.getGroupFilmsBriefInfo(firstResult, pageSize);
		CommentDao commentDao = new CommentDao();
		for(GroupFilmBriefInfo briefInfo:groupFilms){
//			System.out.println(briefInfo.getGroupFilmId());
			briefInfo.setStar(commentDao.getStarByGroupFilmId(briefInfo.getGroupFilmId()));
		}
		return groupFilms;
	}
	public GroupFilmDetailedInfo getGroupFilmDetailInfo(int groupFilmId){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		GroupFilmDetailedInfo info = groupFilmDao.getGroupFilmDetailedInfo(groupFilmId);
		return info;
	}
	/*
	 * 获取所有所有状态的团购电影
	 */
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
