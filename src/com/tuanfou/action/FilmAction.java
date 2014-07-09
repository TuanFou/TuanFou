package com.tuanfou.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.pojo.Film;
import com.tuanfou.service.FilmService;

public class FilmAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Film>  list;
	
	public List<Film> getList() {
		return list;
	}

	public void setList(List<Film> list) {
		this.list = list;
	}

	public String getFilms(){
		FilmService filmService = new FilmService();
		list = filmService.getFilmList();
		if(list == null){
			return "error";
		}else{
			return "apply";
		}
	}
}
