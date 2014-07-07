package com.tuanfou.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.hibernate.Query;
import org.hibernate.Session;
import com.google.gson.Gson;
import com.tuanfou.dao.MerchantDao;
import com.tuanfou.dto.ApplyFilmInfo;
import com.tuanfou.dto.MerchantGroupFilmOrderInfo;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.dto.MerchantInfo;
import com.tuanfou.dto.MessageInfo;
import com.tuanfou.pojo.Merchant;
import com.tuanfou.pojo.Order;
import com.tuanfou.service.MerchantService;
import com.tuanfou.utils.HibernateUtil;



public class MerchantDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addMerchantTest();

//		MerchantService merchantService = new MerchantService();
//		if(merchantService.applyForSale( 11, 301010101, "2014-7-20", "2014-8-20", 19, 25))
//			System.out.println("申请成功");
//		else
//			System.out.println("申请失败");

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
		
		getGroupFilmOrderInfos();
		
		
//		Session session = null;
//		session = HibernateUtil.getSession();
//		List<MerchantGroupFilmOrderInfo> MGFOList = new ArrayList<MerchantGroupFilmOrderInfo>();
//		String hql1 = "from Cinema cinema where cinema.merchant.id = :merchantId";
//		Query query1 = session.createQuery(hql1);
//		query1.setParameter("merchantId", 1);
//		Cinema cinema = new Cinema();
//		if(query1.list().isEmpty())
////			return null;
//			;
//		else{
//			cinema = (Cinema)query1.list().get(0);			
//		}
//		//System.out.println(cinema.getId());
//		String hql2 = "from GroupFilm gf where gf.cinema =:cinema";
//		Query query2 = session.createQuery(hql2);
//		query2.setParameter("cinema", cinema);
//		@SuppressWarnings("unchecked")
//		List<GroupFilm> groupFilmList = query2.list();		
////		System.out.println(groupFilmList.get(1).getId());
//		Iterator<GroupFilm> groupFilmIterator = groupFilmList.iterator();
//		while(groupFilmIterator.hasNext()){
//			GroupFilm groupFilm = groupFilmIterator.next();
//			MerchantGroupFilmOrderInfo MGFOinfo = new MerchantGroupFilmOrderInfo();
//			MGFOinfo.setId(groupFilm.getId());
//			MGFOinfo.setFilmName(groupFilm.getFilm().getFilmName());
//			MGFOinfo.setAddress(groupFilm.getArea().getAreaName());
//			MGFOinfo.setStartDate(groupFilm.getStartDate());
//			MGFOinfo.setEndDate(groupFilm.getEndDate());
//			MGFOinfo.setOriginPrice(groupFilm.getOriginalPrice());
//			MGFOinfo.setCurrentPrice(groupFilm.getCurrentPrice());
//			MGFOinfo.setHeartNum(groupFilm.getUsers().size());
//			MGFOinfo.setOrderNum(getOrderNum(groupFilm));			//number of groupfilm's order
//			MGFOinfo.setType(groupFilm.getType());
//			MGFOList.add(MGFOinfo);
//		}
//		System.out.println(MGFOList.get(0).getId());
		
	}
	
	private static int getOrderNum(GroupFilm groupFilm){
		Session session = null;
		session = HibernateUtil.getSession();
		int groupFilmId = groupFilm.getId();
		String hql = "from Order order where order.groupFilm.id = :groupFilmId";
		Query query = session.createQuery(hql);
		query.setParameter("groupFilmId", groupFilmId);
		@SuppressWarnings("unchecked")
		List<Order> orderList = query.list();
		int orderNum = orderList.size();
		return orderNum;
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
	
	/**
	 * @author yogiman
	 */
	public static void getGroupFilmOrderInfos(){
		MerchantDao merchantDao = new MerchantDao();
		List<MerchantGroupFilmOrderInfo> mgfoList = merchantDao.getGroupFilmOrderInfos(1);
		Gson gson = new Gson();
		String string = gson.toJson(mgfoList);
		System.out.println(string);
	}
}
