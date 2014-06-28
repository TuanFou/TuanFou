package com.tuanfou.test;

import com.tuanfou.dao.CinemaDao;
import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Merchant;

public class CinemaDaoTest {
	public static void main(String[] args) {
		addCinemaTest();
	}
	
	public static void addCinemaTest(){
		Cinema cinema =new Cinema();
		Area area = new Area();
		Merchant merchant = new Merchant();
		area.setId(2);
		merchant.setId(2);
		cinema.setArea(area);
		cinema.setMerchant(merchant);
		cinema.setCinemaName("巨幕影城");
		cinema.setAddress("光谷步行街");
		cinema.setPhoneNumber("13006198684");
		cinema.setDescription("This is a Morden Cinema");
		CinemaDao cinemaDao = new CinemaDao();
		cinemaDao.addCinema(cinema);
		System.out.println(cinema.getDescription());
	}
}
