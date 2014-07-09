package com.tuanfou.service;

import java.util.List;

import com.tuanfou.dao.FilmDao;
import com.tuanfou.pojo.Film;

public class FilmService {
	public List<Film> getFilmList(){
		FilmDao filmDao = new FilmDao();
		List<Film> list = filmDao.getFilmList();
		return list;
	}
}
