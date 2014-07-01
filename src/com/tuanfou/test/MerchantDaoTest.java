package com.tuanfou.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.dao.MerchantDao;
import com.tuanfou.dto.ApplyFilmInfo;
import com.tuanfou.pojo.Merchant;
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
		
		//添加商家测试
		//addMerchantTest();
		
		//商家登陆测试
		loginTes();
		
	}
	public static void insertMerchantTest(){
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
	 *商家登陆测试 
	 */
	public static void loginTes(){
		
		String matching = "ERROR";
		String merchantname = "测试商家";
		String password = "777777888";
		try{

			Session session = HibernateUtil.getSession();
			String hql = "from Merchant merchant where merchant.merchantName=:merchantname and merchant.password=:password";
			Query query = session.createQuery(hql);
			query.setParameter("merchantname", merchantname);
			query.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<Merchant> merchantList = query.list();
			Iterator<Merchant> itMerchant = merchantList.iterator();
			if(itMerchant.hasNext())
				{			
					matching = "SUCCESS";
				}
		}catch(Exception e){
			e.printStackTrace();
			matching = "ERROR";
		}finally{
			HibernateUtil.closeSession();
		}
		System.out.print(matching);
	}
	
	/**
	 *商家注册测试 
	 */
	public static void addMerchantTest(){
		boolean res = true;
		Merchant aMerchant = new Merchant();
		String photoUrl = "default.jpg";
		aMerchant.setMerchantName("测试商家");
		aMerchant.setPassword("777777888");
		aMerchant.setIdNumber("465aaaxaax");
		aMerchant.setPhotoUrl(photoUrl);
		try{
			MerchantService ms = new MerchantService();
			List<Merchant> merchantList = ms.getMerchantList();
			Iterator<Merchant> itMerchant = merchantList.iterator();
			
			while(itMerchant.hasNext())
			{			
				if(itMerchant.next().getIdNumber().equals("465aaaxaax")){
					res = false;
					break;
				}
			}
			if(res) {
				ms.addMerchant(aMerchant);  
			}
		}catch(Exception e){
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		if(res){
			System.out.println("success");
		}
		else{
			System.out.println("fail");
	}
}
}
