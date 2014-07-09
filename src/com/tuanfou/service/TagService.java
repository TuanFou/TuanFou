package com.tuanfou.service;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dao.TagDao;
import com.tuanfou.dto.TagInfo;
import com.tuanfou.pojo.Film;

/**
 * 获取首页标签信息
 * @author LN
 *
 */
public class TagService {
	public List<TagInfo> getTagInfoList(){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		int totalFilmNums = groupFilmDao.getTotalGroupFilmNum();
		System.out.println("totalNumber:"+totalFilmNums);
		
		TagInfo total = new TagInfo();
		total.setFilmNum(totalFilmNums);
		total.setTagName("全部");
		
		TagDao tagDao = new TagDao();
		List<TagInfo> tagInfoList = tagDao.getTagInfoList();	
		Iterator<TagInfo> it = tagInfoList.iterator();
		while(it.hasNext()){
			TagInfo tagInfo = it.next();
			int number = 0;
			Set<Film> films = tagDao.findFilms(tagInfo.getTagId());
			Iterator<Film> filmIt = films.iterator();
			while(filmIt.hasNext()){
				Film film = filmIt.next();
				int n = groupFilmDao.getFilmNum(film.getId());
				number = number + n;
			}
			tagInfo.setFilmNum(number);
		}
		tagInfoList.add(0, total);
		return tagInfoList;
	}
	
}
