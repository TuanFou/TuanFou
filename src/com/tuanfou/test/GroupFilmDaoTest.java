package com.tuanfou.test;



import java.util.Date;
import java.util.Iterator;
import java.util.List;


import com.google.gson.Gson;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dto.FilmStatusInfo;
import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.dto.GroupFilmDetailedInfo;
import com.tuanfou.dto.GroupFilmForm;
import com.tuanfou.dto.InvitedMember;
import com.tuanfou.dto.RecommendFilm;

import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.service.FilmStatusService;
import com.tuanfou.service.GroupFilmService;

public class GroupFilmDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		TODO some test
		//groupfilmDetailedInfoTest(1);
//		FilmStatusService filmStatusService = new FilmStatusService();
//		List<FilmStatusInfo> statusInfo = filmStatusService.getStatusInfo();
//		Iterator<FilmStatusInfo> it = statusInfo.iterator();
//		while(it.hasNext()){
//			FilmStatusInfo filmStatusInfo = it.next();
//			System.out.println("Status:"+filmStatusInfo.getStatus()+"	Number:"+filmStatusInfo.getFilmNum());
//		}
		//filmstatus
//		FilmStatusService se = new FilmStatusService();
//		List<FilmStatusInfo> list = se.getStatusInfo();
//		Gson gson = new Gson();
//		String str = gson.toJson(list);
//		System.out.println(str);
//		GroupFilmDao groupFlimDao = new GroupFilmDao();
//		List<GroupFilm> groupFilm = groupFlimDao.getGroupFilms(0, Integer.MAX_VALUE);
//		Gson gson = new Gson();
//
//		System.out.println(groupFilm);
		
		//groupfilmDetailedInfoTest();
//		GroupFilmService groupFilmService = new GroupFilmService();
//		List<RecommendFilm> films = groupFilmService.getRecommendFilms(3,2);
//		Iterator<RecommendFilm> it = films.iterator();
//		while(it.hasNext())
//		{
//			RecommendFilm film = it.next();
//			System.out.println("FilmName："+film.getFilmName()+"	cinemaName:"+film.getCinemaName()+"	userNum:"+film.getUserNum()+"	picUrl"+film.getPicUrl());
//		}
//		Gson gson = new Gson();
//		String result = gson.toJson(films);
//		System.out.println(result);
		//groupfilmDetailedInfoTest();
 
//		GroupFilmForm groupFilmForm= new GroupFilmForm();
//		groupFilmForm.setMerchantId(1);
//		groupFilmForm.setFilmId(5);
//		groupFilmForm.setCinemaId(319010101);
//		groupFilmForm.setCurrentPrice(18.5f);
//		groupFilmForm.setOriginalPrice(25.0f);
//		groupFilmForm.setStartDate(new java.sql.Date(new java.util.Date().getTime()));
//		groupFilmForm.setEndDate(new java.sql.Date(new java.util.Date().getTime()));
//		groupFilmForm.setRemark("不错的电影");
//		groupFilmForm.setPhotoUrl("./imgs/1.png");
//		
//		GroupFilmService groupFilmService = new GroupFilmService();
//		groupFilmService.addGroupFilm(groupFilmForm);
		/*
		 * 测试想看人员
		 */
		GroupFilmService groupFilmService = new GroupFilmService();
		List<InvitedMember> list = groupFilmService.getJoinMember(1, 0, 5);
		Gson gson = new Gson();
		String str = gson.toJson(list);
		System.out.println(str);
	}
	public static void groupfilmBriefInfoTest(){
//		private int id;
//		private Film  film;
//		private Merchant merchant;
//		private Area area;
//		private Cinema cinema;
//		private float currentPrice;//���ۺ�ļ۸�
//		private float originalPrice;//����ǰ�ļ۸�
//		private Date startDate;
//		private Date endDate;
//		private int status;  //0:�����У�1:���ϼܣ�2���¼�
//		private String remark;//��ע
//		private int type;//0:�Ѿ���ӳ, 1��������ӳ��2���¼�
		GroupFilmDao groupFilmDao = new GroupFilmDao();
//		GroupFilm groupFilm = new GroupFilm();
//		Film film = new Film();
//		film.setId(1);
//		Merchant merchant  = new Merchant();
//		merchant.setId(3);
//		Area area = new Area();
//		area.setId(1);
//		Cinema cinema = new Cinema();
//		cinema.setId(1);
//		
//		groupFilm.setArea(area);
//		groupFilm.setCinema(cinema);
//		groupFilm.setMerchant(merchant);
//		groupFilm.setFilm(film);
//		
//		groupFilm.setCurrentPrice(19.0f);
//		groupFilm.setOriginalPrice(20.0f);
//		groupFilm.setRemark("hello");
//		groupFilm.setStartDate(new java.sql.Date(new java.util.Date().getTime()));
//		groupFilm.setEndDate(new java.sql.Date(new java.util.Date().getTime()));
//		if(groupFilmDao.addGroupFilm(groupFilm)){
//			System.out.println("success");
//		}else{
//			System.out.println("failed");
//		}
		
		//������ʾ�б�
//		GroupFilmDao groupFilmDao = new GroupFilmDao();
//		//List<GroupFilm> groupFilms = groupFilmDao.getGroupFilms(0, 1);
//		List<GroupFilmBriefInfo> groupFilms = groupFilmDao.getGroupFilmsBriefInfo(0, 10);
//		System.out.println(groupFilms);
		
		//GroupFilmService se = new GroupFilmService();
		//List<GroupFilmBriefInfo> list = se.loadGroupFilmsBriefInfo(0, 10);
//		for(GroupFilmBriefInfo tem:list){
//			System.out.println("����:"+tem.getCinemaName()+tem.getStar());
//		}

		//GroupFilmBriefInfo info = list.get(0);

//		List<String> tags = new ArrayList<String>();
//		tags.add("����");
//		tags.add("����");
//		info.setTags(tags);
		//Gson gson = new Gson();
		//String str = gson.toJson(list);
		//System.out.println(str);
		
//		int number = groupFilmDao.getAreaGroupFilmNum(1);
//		System.out.println(number);
//		GroupFilmService gs = new GroupFilmService();
//		List<GroupFilmBriefInfo> list = gs.loadGroupFilmsBriefInfo(0, 10);
//		Gson gson = new Gson();
//		String str = gson.toJson(list);
//		System.out.println(str);
		
	}
	
	public static void groupfilmDetailedInfoTest(){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		GroupFilmDetailedInfo groufilmDetailedInfo = groupFilmDao.getGroupFilmDetailedInfo(1);		
		Gson gson = new Gson();
		String str = gson.toJson(groufilmDetailedInfo);
		System.out.println(str);
		
	}
	
	
	public static void countCommentsTest(int groupFilmId){
//		GroupFilmDao groupFilmDao = new GroupFilmDao();
//		int i = groupFilmDao.getCountComments(groupFilmId);
//		Gson gson = new Gson();
//		String str = gson.toJson(i);
//		System.out.println(str);
	}
	
	public static void countGroupMemberNumberTest(int groupFilmId){
//		GroupFilmDao groupFilmDao = new GroupFilmDao();
//		int i = groupFilmDao.getOderNum(groupFilmId);
//		Gson gson = new Gson();
//		String str = gson.toJson(i);
//		System.out.println(str);
	}
	
}
