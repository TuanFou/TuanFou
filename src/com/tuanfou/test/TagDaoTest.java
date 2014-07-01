package com.tuanfou.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.tuanfou.dao.TagDao;
import com.tuanfou.dto.TagInfo;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.Tag;
import com.tuanfou.service.TagService;

public class TagDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Tag tag = new Tag();
		tag.setTagName("����");
		TagDao tagDao = new TagDao();
		int tagId = tagDao.findId(tag.getTagName());
		System.out.println("tagId:"+tagId);
		Set<Film> films = tagDao.findFilms(tagId);
		Iterator<Film> it = films.iterator();
		while(it.hasNext()){
			Film film = it.next();
			System.out.println("��Ӱid��"+film.getId());
		}*/
//		film.setId(1);
//		Set<Film> films = new HashSet<Film>();
//		films.add(film);
	//	tag.setFilms(films);	
		
		//tagDao.add(tag);
		TagService tagService = new TagService();
		List<TagInfo> tagInfoList = tagService.getTagInfoList();
//		Gson gson = new Gson();
//		String str = gson.toJson(tagInfoList);
//		System.out.println(str);
//		Iterator<TagInfo> it = tagInfoList.iterator();
//		while(it.hasNext()){
//			TagInfo tagInfo = (TagInfo) it.next();
//			System.out.println("tagName："+tagInfo.getTagName()+"	number:"+tagInfo.getFilmNum());	
//		}	
		
	}

}
