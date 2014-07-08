package com.tuanfou.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.ApplyFilmInfo;
import com.tuanfou.pojo.Merchant;
import com.tuanfou.pojo.User;
import com.tuanfou.service.MerchantService;
import com.tuanfou.utils.HibernateUtil;

public class MerchantAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest req;
	private HttpServletResponse response;
	private MerchantService merchantService;
	
	/**
	 * 商家登录
	 * 参数：用户名username;密码password                                            
	 */
	public String login(){
		
		String matching = ERROR;
		req = ServletActionContext.getRequest();
		String merchantname = req.getParameter("merchantname");
		String password = req.getParameter("password");
		try{

			Session session = HibernateUtil.getSession();
			String hql = "from Merchant merchant where merchant.merchantName=:merchantname and merchant.password=:password";
			Query query = session.createQuery(hql);
			query.setParameter("merchantname", merchantname);
			query.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<Merchant> merchantList = query.list();
			Iterator<Merchant> itMerchant =merchantList.iterator();
			if(itMerchant.hasNext())
				{			
					matching = SUCCESS;
				}
		}catch(Exception e){
			e.printStackTrace();
			matching = ERROR;
		}finally{
			HibernateUtil.closeSession();
		}
		return matching;
	}
	
	/**
	 *注册新商家
	 *参数：用户名username;密码password;身份证号idNumber
	 */
	public boolean regist(){
		boolean res = true;
		req = ServletActionContext.getRequest();
		Merchant aMerchant = new Merchant();
		String merchantName = req.getParameter("merchantname");
		String password = req.getParameter("password");
		String idNumber = req.getParameter("idNumber");
		//photoUrl 给默认值
		String photoUrl = "default.jpg";
		aMerchant.setMerchantName(merchantName);
		aMerchant.setPassword(password);
		aMerchant.setIdNumber(idNumber);
		aMerchant.setPhotoUrl(photoUrl);
		try{
			MerchantService ms = new MerchantService();
			List<Merchant> merchantList = ms.getMerchantList();
			Iterator<Merchant> itMerchant =merchantList.iterator();
			
			while(itMerchant.hasNext())
			{			
				if(itMerchant.next().getIdNumber().equals(idNumber)){
					res = false;
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
		return res;
	}
	/**
	 *商家发布商品
	 *参数：用户名username;密码password;身份证号idNumber
	 */
	public String addNewGroupFilm(){
		req = ServletActionContext.getRequest();
		
		int merchantId = Integer.valueOf(req.getParameter("merchantId"));
		String filmName = req.getParameter("filmName");
		String releaseTime = req.getParameter("releaseTime");
		String version = req.getParameter("version");
		int period = Integer.valueOf(req.getParameter("period"));
		String country = req.getParameter("country");
		String description = req.getParameter("description");
		String director = req.getParameter("director");
		String actor = req.getParameter("actor");
		int star = Integer.valueOf(req.getParameter("star"));
		Map<Integer,String>tags = new HashMap<Integer, String>();
		
		
		ApplyFilmInfo newFilm = new ApplyFilmInfo();
		newFilm.setMerchantId(merchantId);
		newFilm.setActor(actor);
		newFilm.setCountry(country);
		newFilm.setDescription(description);
		newFilm.setDirector(director);
		newFilm.setFileName(filmName);
		newFilm.setPeriod(period);
		newFilm.setMerchantId(merchantId);
		newFilm.setReleaseTime(releaseTime);
		newFilm.setStar(star);
		newFilm.setTags(tags);
		newFilm.setVersion(version);
		
		MerchantService merchantService = new MerchantService();
		if(merchantService.applyNewFilm(newFilm))
			return "applyNewFilmSuccess";
		else
			return "applyNewFilmSuccessFailure";
	}
	
	public String applyForSale(){
		req = ServletActionContext.getRequest();
		
		int filmId = Integer.valueOf(req.getParameter("filmId"));
		int cinemaId = Integer.valueOf(req.getParameter("cinemaId"));
		String stime = req.getParameter("starttime");
		String etime = req.getParameter("endtime");
		float currentPrice = Float.valueOf(req.getParameter("currentPrice"));
		float originalPrice = Float.valueOf(req.getParameter("originalPrice"));
		
		
		MerchantService merchantService = new MerchantService();
		if(merchantService.applyForSale(filmId, cinemaId, stime, etime, currentPrice, originalPrice))
			return "applyForSaleSuccess";
		else
			return "applyForSaleFailure";
	}
}
