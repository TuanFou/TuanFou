package com.tuanfou.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.tuanfou.dao.FilmDao;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.Merchant;
import com.tuanfou.pojo.Tag;

public class FilmDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findTagsTest();
	}
	public static void addFilmTest(){
		/*Film film = new Film();
		Merchant merchant = new Merchant();
		Date date = new Date(new java.util.Date().getTime());
		merchant.setId(1);
		film.setMerchant(merchant);
		film.setFilmName("���ν��2");
		film.setActors("��ά˹");
		film.setReleaseDate(date);
		film.setVersion("Chinese");
		film.setCountry("America");
		film.setPeriod(120);
		film.setDescription("this is a splendid action film");
		film.setDirector("siperberg");
		film.setStar(5);
		film.setStatus(0);
		film.setApplicateTime(new Timestamp(System.currentTimeMillis()));
		
		film.setAuditResult(0);
		FilmDao filmDao = new FilmDao();
		filmDao.addFilm(film);
		System.out.println(film.getReleaseDate());*/
		FilmDao filmDao = new FilmDao();
		int number = filmDao.getTotalFilmsNum();
		System.out.println("电影总数："+number);
	}
	
	public static void findTagsTest(){
//		FilmDao filmDao = new FilmDao();
//		List<Tag> tag = filmDao.findTags(1);
//		Gson gson = new Gson();
//		String str = gson.toJson(tag);
//		System.out.println(str);
	}
}
