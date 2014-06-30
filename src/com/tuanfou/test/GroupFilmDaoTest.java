package com.tuanfou.test;

//import java.sql.Date;

import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Merchant;

public class GroupFilmDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		private int id;
//		private Film  film;
//		private Merchant merchant;
//		private Area area;
//		private Cinema cinema;
//		private float currentPrice;//打折后的价格
//		private float originalPrice;//打折前的价格
//		private Date startDate;
//		private Date endDate;
//		private int status;  //0:申请中，1:已上架，2：下架
//		private String remark;//备注
//		private int type;//0:已经上映, 1：即将上映，2：下架
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		GroupFilm groupFilm = new GroupFilm();
		Film film = new Film();
		film.setId(1);
		Merchant merchant  = new Merchant();
		merchant.setId(3);
		Area area = new Area();
		area.setId(1);
		Cinema cinema = new Cinema();
		cinema.setId(1);
		
		groupFilm.setArea(area);
		groupFilm.setCinema(cinema);
		groupFilm.setMerchant(merchant);
		groupFilm.setFilm(film);
		
		groupFilm.setCurrentPrice(19.0f);
		groupFilm.setOriginalPrice(20.0f);
		groupFilm.setRemark("hello");
		groupFilm.setStartDate(new java.sql.Date(new java.util.Date().getTime()));
		groupFilm.setEndDate(new java.sql.Date(new java.util.Date().getTime()));
		if(groupFilmDao.addGroupFilm(groupFilm)){
			System.out.println("success");
		}else{
			System.out.println("failed");
		}
	}

}
