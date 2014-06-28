package com.tuanfou.test;

import java.util.HashSet;
import java.util.Set;

import com.tuanfou.dao.TagDao;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.Tag;

public class TagDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tag tag = new Tag();
		tag.setFilmNum(0);
		tag.setTagName("°®Çé");
		Film film = new Film();
		film.setId(1);
		Set<Film> films = new HashSet();
		films.add(film);
		tag.setFilms(films);	
		TagDao tagDao = new TagDao();
		tagDao.add(tag);
		
	}

}
