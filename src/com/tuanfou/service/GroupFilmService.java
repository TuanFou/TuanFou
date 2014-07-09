package com.tuanfou.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.tuanfou.dao.CinemaDao;
import com.tuanfou.dao.CommentDao;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dto.FilmStatusInfo;
import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.dto.GroupFilmDetailedInfo;
import com.tuanfou.dto.GroupFilmForm;
import com.tuanfou.dto.InvitedMember;
import com.tuanfou.dto.RecommendFilm;
import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Merchant;
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
	/*
	 * 添加团购电影
	 * 	private int id;
	private Film  film;
	private Merchant merchant;
	private Area area;
	private Cinema cinema;
	private float currentPrice;//���ۺ�ļ۸�
	private float originalPrice;//����ǰ�ļ۸�
	private Date startDate;
	private Date endDate;
	private int status;  //0:�����У�1:���ϼܣ�2���¼�
	private String remark;//��ע
	private int type;//0:�Ѿ���ӳ, 1��������ӳ��2���¼�
	private String picUrl;//图片路径
	 */
	public boolean addGroupFilm(GroupFilmForm groupFilmForm){
		GroupFilm groupFilm = new GroupFilm();
		Film film = new Film();
		film.setId(groupFilmForm.getFilmId());
		
		Merchant merchant = new Merchant();
		merchant.setId(groupFilmForm.getMerchantId());
		
		Cinema cinema = new Cinema();
		cinema.setId(groupFilmForm.getCinemaId());
		
		Area area = new Area();
		int id = new CinemaDao().getCinema(groupFilmForm.getCinemaId()).getArea().getId();
		area.setId(id);
		
		groupFilm.setFilm(film);
		groupFilm.setCinema(cinema);
		groupFilm.setMerchant(merchant);
		groupFilm.setArea(area);
		groupFilm.setCurrentPrice(groupFilmForm.getCurrentPrice());
		groupFilm.setOriginalPrice(groupFilmForm.getOriginalPrice());
		groupFilm.setStartDate(groupFilmForm.getStartDate());
		groupFilm.setEndDate(groupFilmForm.getEndDate());
		groupFilm.setPicUrl(groupFilmForm.getPhotoUrl());
		groupFilm.setRemark(groupFilmForm.getRemark());
		groupFilm.setStatus(1);//设置为上架状态
		groupFilm.setType(groupFilmForm.getType());
		
		film.setId(groupFilmForm.getFilmId());
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		if(groupFilmDao.addGroupFilm(groupFilm)){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 添加想看的用户
	 */
	public boolean addHeartUser(int groupFilmId,int userId){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		return groupFilmDao.addHartUser(userId, groupFilmId);
	}
	/*
	 * 李处指定团购电影的想看用户
	 */
	public List<InvitedMember> getJoinMember(int groupFilmId,int firstResult,int maxResult){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		return groupFilmDao.getInvitedMembers(groupFilmId, firstResult, maxResult);
	}
}
