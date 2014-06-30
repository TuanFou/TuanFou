package com.tuanfou.test;

import java.sql.Timestamp;
import java.util.Date;

import com.tuanfou.dao.FilmDao;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.Merchant;

public class FilmDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addFilmTest();
	}
	public static void addFilmTest(){
		Film film = new Film();
		Merchant merchant = new Merchant();
		Date date = new Date(new java.util.Date().getTime());
		merchant.setId(1);
		film.setMerchant(merchant);
		film.setFilmName("变形金刚2");
		film.setActors("李维斯");
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
		System.out.println(film.getReleaseDate());
		
	}
}
