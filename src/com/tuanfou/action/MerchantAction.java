package com.tuanfou.action;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.MerchantInfo;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.Merchant;
import com.tuanfou.pojo.User;
import com.tuanfou.service.FilmService;
import com.tuanfou.service.MerchantService;
import com.tuanfou.utils.HibernateUtil;

public class MerchantAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest req;
	private HttpServletResponse response;
	private Map<String ,Object> ses;//session
	private MerchantService merchantService;
	private MerchantInfo merchantInfo;
	private List<Film>  filmList;
	public List<Film> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
	}
	private Set<Cinema> cinemaList;
	public MerchantInfo getMerchantInfo() {
		return merchantInfo;
	}

	public void setMerchantInfo(MerchantInfo merchantInfo) {
		this.merchantInfo = merchantInfo;
	}
	

	public Set<Cinema> getCinemaList() {
		return cinemaList;
	}

	public void setCinemaList(Set<Cinema> cinemaList) {
		this.cinemaList = cinemaList;
	}

	/**
	 * 商家登录
	 * 参数：用户名username;密码password                                            
	 * @throws UnsupportedEncodingException 
	 */
	public String login() throws UnsupportedEncodingException{
		
		String matching = "merchant_login";
		req = ServletActionContext.getRequest();
		req.setCharacterEncoding("utf-8");
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
				matching = "merchantHome";
				ses = ActionContext.getContext().getSession();
				ses.put("merchantName", merchantname);
				ses.put("merchantId", itMerchant.next().getId());
				return showMerchantHome();
			}
		}catch(Exception e){
			e.printStackTrace();
			matching = "merchant_login";
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
	/*
	 * 商家个人资料
	 */
	public String showMerchantHome(){
		//通过session获取商家id
		ses = ActionContext.getContext().getSession();
		int id = (Integer)ses.get("merchantId");
		MerchantService merchantService = new MerchantService();
		merchantInfo = merchantService.getMerchantInfo(id);
		if(merchantInfo !=null)
			return "merchantHome";		
		return "error";
		
	}
	/*
	 * 初始化申请表
	 */
	public String initApplyInfo(){
		//merchantId从session获取
		int merchantId = 1;
		FilmService filmService = new FilmService();
		MerchantService merchantService = new MerchantService();
		cinemaList = merchantService.getMerchantCinemas(merchantId);
		filmList = filmService.getFilmList();
		if(cinemaList == null || filmList==null){
			return "error";
		}else{
			return "apply";
		}
	}
}
