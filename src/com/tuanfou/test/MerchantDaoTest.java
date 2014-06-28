package com.tuanfou.test;

import com.tuanfou.dao.MerchantDao;
import com.tuanfou.pojo.Merchant;



public class MerchantDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addMerchantTest();
	}
	public static void addMerchantTest(){
		Merchant merchant = new Merchant();
		merchant.setMerchantName("ÐìÓà¼ª");
		merchant.setIdNumber("32108800000000000");
		merchant.setPassword("xuyuji9000");
		merchant.setPhotoUrl("yogi.jpg");
		MerchantDao merchantDao = new MerchantDao();
		merchantDao.addMerchant(merchant);
		System.out.println(merchant.getIdNumber());
	}
}
