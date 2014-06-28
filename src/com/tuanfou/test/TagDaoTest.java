package com.tuanfou.test;

import java.util.Iterator;
import java.util.Set;

import com.tuanfou.dao.TagDao;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.Tag;

public class TagDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tag tag = new Tag();
		tag.setTagName("∞Æ«È");
		TagDao tagDao = new TagDao();
		int tagId = tagDao.findId(tag.getTagName());
		System.out.println("tagId:"+tagId);
		Set<Film> films = tagDao.findFilms(tagId);
		Iterator<Film> it = films.iterator();
		while(it.hasNext()){
			Film film = it.next();
			System.out.println("µÁ”∞id£∫"+film.getId());
		}
//		film.setId(1);
//		Set<Film> films = new HashSet<Film>();
//		films.add(film);
	//	tag.setFilms(films);	
		
		//tagDao.add(tag);
		
		
		
	}

}
