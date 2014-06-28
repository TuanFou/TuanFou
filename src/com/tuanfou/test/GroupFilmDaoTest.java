package com.tuanfou.test;

import java.sql.Date;

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
//		private float currentPrice;//���ۺ�ļ۸�
//		private float originalPrice;//����ǰ�ļ۸�
//		private Date startDate;
//		private Date endDate;
//		private int status;  //0:�����У�1:���ϼܣ�2���¼�
//		private String remark;//��ע
//		private int type;//0:�Ѿ���ӳ, 1��������ӳ��2���¼�
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
