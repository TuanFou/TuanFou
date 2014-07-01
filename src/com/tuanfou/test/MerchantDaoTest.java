package com.tuanfou.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.tuanfou.dao.MerchantDao;
import com.tuanfou.dto.ApplyFilmInfo;
import com.tuanfou.dto.MerchantInfo;
import com.tuanfou.dto.MessageInfo;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Merchant;
import com.tuanfou.service.MerchantService;



public class MerchantDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addMerchantTest();
		MerchantService merchantService = new MerchantService();
		/*if(merchantService.applyForSale( 11, 301010101, "2014-7-20", "2014-8-20", 19, 25))
			System.out.println("申请成功");
		else
			System.out.println("申请失败");*/
		if(merchantService.updateProfile(1, "123", "123456"))
			System.out.println("更新成功");
		else
			System.out.println("更新失败");
		
		/*ApplyFilmInfo afilm = new ApplyFilmInfo();
		afilm.setActor("巩俐");
		afilm.setCountry("大陆");
		afilm.setDescription("归来之作");
		afilm.setDirector("张艺谋");
		afilm.setFileName("归来");
		afilm.setMerchantId(1);
		afilm.setPeriod(120);
		afilm.setReleaseTime("2014-6-13");
		afilm.setStar(4);
		Map<Integer,String> tags = new HashMap<Integer,String>();
		tags.put(1, "爱情");
		tags.put(13, "剧情");
		afilm.setTags(tags);
		afilm.setVersion("一");
		if(merchantService.applyNewFilm(afilm))
			System.out.println("申请成功");
		else
			System.out.println("申请失败");*/
		
	}
	public static void addMerchantTest(){
		Merchant merchant = new Merchant();
		merchant.setMerchantName("���༪");
		merchant.setIdNumber("32108800000000000");
		merchant.setPassword("xuyuji9000");
		merchant.setPhotoUrl("yogi.jpg");
		MerchantDao merchantDao = new MerchantDao();
		merchantDao.addMerchant(merchant);
		System.out.println(merchant.getIdNumber());
	}
}
