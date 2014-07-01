package com.tuanfou.service;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dao.TagDao;
import com.tuanfou.dto.TagInfo;
import com.tuanfou.pojo.Film;


public class TagService {
	public List<TagInfo> getTagInfoList(){
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		int totalFilmNums = groupFilmDao.getTotalGroupFilmNum();
		System.out.println("totalNumber:"+totalFilmNums);
		
		TagInfo tagInfo = new TagInfo();
		tagInfo.setFilmNum(totalFilmNums);
		tagInfo.setTagName("全部");
		
		TagDao tagDao = new TagDao();
		List<TagInfo> tagInfoList = tagDao.getTagInfoList();	
		tagInfoList.add(0, tagInfo);
		return tagInfoList;
	}

}
