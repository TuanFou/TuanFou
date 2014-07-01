package com.tuanfou.service;

import java.util.List;

import com.tuanfou.dao.CommentDao;
import com.tuanfou.dao.GroupFilmDao;
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
}
