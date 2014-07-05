package com.tuanfou.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.tuanfou.dao.AdminDao;
import com.tuanfou.dao.CinemaDao;
import com.tuanfou.dao.FilmDao;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dao.MerchantDao;
import com.tuanfou.dao.MessageDao;
import com.tuanfou.dao.TagDao;
import com.tuanfou.dto.ApplyFilmInfo;
import com.tuanfou.dto.MerchantInfo;
import com.tuanfou.dto.MessageInfo;
import com.tuanfou.pojo.Admin;
import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Merchant;
import com.tuanfou.pojo.Tag;

public class MerchantService {
   /**
    * 商家申请电影上架
    * @param merchantId
    * @param filmId
    * @param cinemaId
    * @param date
    * @param validate
    * @param currentPrice
    * @param originalPrice
    * @return
    */
	public boolean applyForSale( int filmId, int cinemaId, String stime, String etime, float currentPrice, float originalPrice){
		GroupFilm groupFilm = new GroupFilm();
		groupFilm.setOriginalPrice(originalPrice);
		groupFilm.setStatus(1);
		groupFilm.setType(1);
		groupFilm.setCurrentPrice(currentPrice);
		groupFilm.setComments(null);
		groupFilm.setComments(null);
		groupFilm.setRemark(null);
		groupFilm.setUsers(null);
		
		FilmDao filmDao = new FilmDao();
		CinemaDao cinemaDao = new CinemaDao();
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		Film film = filmDao.getFilm(filmId);
		Set<Tag> tags = filmDao.getTags(film.getId());
		Cinema cinema = cinemaDao.getCinema(cinemaId);
		Area area = cinemaDao.getArea(cinemaId);
		
		groupFilm.setCinema(cinema);
		groupFilm.setFilm(film);
		groupFilm.setArea(area);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			java.util.Date sdate = format.parse(stime);
			java.util.Date edate = format.parse(etime);
			Date startDate = new Date(sdate.getTime());
			Date endDate = new Date(edate.getTime());
			groupFilm.setStartDate(startDate);
			groupFilm.setEndDate(endDate);
			if(groupFilmDao.addGroupFilm(groupFilm)){
				//更新标签表中的团购电影数目
				TagDao tagDao = new TagDao();
				Iterator<Tag> it = tags.iterator();
				while(it.hasNext()){
					Tag tag = it.next();
					int number = tag.getFilmNum();
					number++;
					tag.setFilmNum(number);
					tagDao.update(tag);
				}
				return true;
			}
			else
				return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}			
	}
	
	/**
	 * 申请新电影
	 * @param afilm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean applyNewFilm(ApplyFilmInfo afilm){
		FilmDao filmDao = new FilmDao();
		MerchantDao merchantDao = new MerchantDao();
		TagDao tagDao = new TagDao();
		Merchant merchant = merchantDao.getMerchant(afilm.getMerchantId());
		Film film = new Film();
		film.setActors(afilm.getActor());
		film.setCountry(afilm.getCountry());
		film.setDescription(afilm.getDescription());
		film.setDirector(afilm.getDirector());
		film.setFilmName(afilm.getFileName());
		film.setPeriod(afilm.getPeriod());
		film.setStar(afilm.getStar());
		film.setStatus(0);
		film.setAuditResult(0);
		film.setVersion(afilm.getVersion());
		Timestamp timeStamp = new Timestamp(new java.util.Date().getTime());
		film.setApplicateTime(timeStamp);
		film.setMerchant(merchant);
		Set<Tag> tags = new HashSet<Tag>();
		Map<Integer,String> tagMap = afilm.getTags();
		Iterator it = tagMap.entrySet().iterator();
		//获得该电影的标签，更新film-tag表
		while(it.hasNext()){
			Map.Entry aTag =  (Entry) it.next();
			int tagId = (Integer) aTag.getKey();
			Tag tag = tagDao.getTag(tagId);
			tags.add(tag);	
		}
		film.setTags(tags);
		
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    try{
	    	java.util.Date rdate = format.parse(afilm.getReleaseTime());
	    	Date releaseDate = new Date(rdate.getTime());
	    	film.setReleaseDate(releaseDate);
	    	return filmDao.addFilm(film);
	    }
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 获得管理员发送来的消息
	 * @param merchantId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<MessageInfo> getMsg(int merchantId,int page,int pageSize){
		MessageDao messageDao = new MessageDao();
		AdminDao adminDao = new AdminDao();
		List<MessageInfo> msgInfoList = messageDao.findReceiveMsg(0, merchantId);
		List<MessageInfo> msgList = new ArrayList<MessageInfo>();
		int number = 1;
		Iterator<MessageInfo> it = msgInfoList.iterator();
		while(it.hasNext()){
			MessageInfo msgInfo = it.next();
			if(number > (page-1)*pageSize && number <= page*pageSize)
			{
				Admin admin = adminDao.getAdmin(msgInfo.getSenderId());
				msgInfo.setSenderName(admin.getName());
				msgList.add(msgInfo);
				number++;
			}
			if(number > page*pageSize)
				break;
		}
		return msgList;
	}
	/**
	 * 商家获得个人信息
	 * @param merchantId
	 * @return
	 */
	public MerchantInfo getMerchantInfo(int merchantId){
		MerchantDao merchantDao = new MerchantDao();
		MerchantInfo merchantInfo = new MerchantInfo();
		Merchant merchant = merchantDao.getMerchant(merchantId);
		Set<Cinema> cinemas = merchantDao.getCinema(merchantId);
		merchantInfo.setMerchantId(merchantId);
		merchantInfo.setCinemas(cinemas);
		merchantInfo.setMerchantName(merchant.getMerchantName());
		merchantInfo.setPassword(merchant.getPassword());
		return merchantInfo;   //这个对象好像不能转为Gson
	}
	
	/**
	 * 商家修改密码
	 * @param merchantId
	 * @param oldPsw
	 * @param newPsw
	 * @return
	 */
	public boolean updateProfile(int merchantId,String oldPsw,String newPsw){
		MerchantDao merchantDao = new MerchantDao();
		Merchant merchant = merchantDao.getMerchant(merchantId);
		System.out.println("input psw:"+oldPsw);
		System.out.println("old psw:"+merchant.getPassword());
		if(merchant.getPassword().equals(oldPsw)){
			//更新
			merchant.setPassword(newPsw);
			return (merchantDao.update(merchant));
		}
		else
			return false;    //密码错误
	}
}
