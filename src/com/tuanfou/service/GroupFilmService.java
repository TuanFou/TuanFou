package com.tuanfou.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.tuanfou.dao.CommentDao;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dto.FilmStatusInfo;
import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.dto.GroupFilmDetailedInfo;
import com.tuanfou.dto.RecommendFilm;
import com.tuanfou.utils.ComparatorFilm;

public class GroupFilmService {
	/*
	 * ָ��ҳ���ÿҳ��ʾ��������ظ��
	 */
	public List<GroupFilmBriefInfo> loadGroupFilmsBriefInfo(int firstResult,int pageSize,String areaName,int type,List<String> tagList){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		List<GroupFilmBriefInfo> groupFilms = groupFilmDao.getGroupFilmsBriefInfo(firstResult, pageSize,areaName,type,tagList);
		//List<GroupFilmBriefInfo> groupFilms = groupFilmDao.getGroupFilmsBriefInfo(firstResult, pageSize);
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
	
	/*
	 * 获取所有推荐电影
	 * 参数：页数，和每页电影数
	 */
	@SuppressWarnings("unchecked")
	public List<RecommendFilm> getRecommendFilms(int pageSize,int page){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		List<RecommendFilm> films = groupFilmDao.getNoffFilm();  //获得当前正在放映或即将放映的团购电影
		List<RecommendFilm> recommendFilms = new ArrayList<RecommendFilm>();  //存放前五名团购电影
	
		ComparatorFilm comparator = new ComparatorFilm();
		Collections.sort(films,comparator);
		
		Iterator<RecommendFilm> it = films.iterator();
		int rank = 0;
		for(int i = 1; i <= films.size(); i++)
		{
			RecommendFilm aFilm = it.next();
			rank ++;
			if((i > (page-1)*pageSize)&&(i <= page * pageSize))
			{
				aFilm.setRank(rank);
				recommendFilms.add(aFilm);
			}
			if(i > page*pageSize)
				break;
		}
		return recommendFilms;
	}
	
}
