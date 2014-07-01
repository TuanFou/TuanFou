package com.tuanfou.test;



import java.util.List;


import com.google.gson.Gson;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.dto.GroupFilmDetailedInfo;

import com.tuanfou.service.GroupFilmService;

public class GroupFilmDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		groupfilmDetailedInfoTest(1);
	}
	public static void groupfilmBriefInfoTest(){
		// TODO Auto-generated method stub
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
	
	public static void groupfilmDetailedInfoTest(int id){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		GroupFilmDetailedInfo groufilmDetailedInfo = groupFilmDao.getGroupFilmDetailedInfo(id);		
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
