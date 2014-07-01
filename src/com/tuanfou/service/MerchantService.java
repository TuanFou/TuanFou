package com.tuanfou.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.tuanfou.dao.CinemaDao;
import com.tuanfou.dao.FilmDao;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dao.MerchantDao;
import com.tuanfou.dao.TagDao;
import com.tuanfou.dao.UserDao;
import com.tuanfou.dto.ApplyFilmInfo;
import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Merchant;
import com.tuanfou.pojo.Tag;
import com.tuanfou.pojo.User;

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
	 * 添加商家
	 */
	public boolean addMerchant(Merchant merchant){
		MerchantDao merchantDao = new MerchantDao();
		if(merchantDao.addMerchant(merchant)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 获取商家列表
	 * @return
	 */
	public List<Merchant> getMerchantList(){
		MerchantDao merchantDao = new MerchantDao();
		return merchantDao.getMerchantList();
	}
}
