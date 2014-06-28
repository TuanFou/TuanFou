package com.tuanfou.pojo;

import java.util.Set;

public class Tag {
	private int id;
	private String tagName;
	private int filmNum;//电影数量
	
	private Set<Film> films;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
	public Set<Film> getFilms() {
		return films;
	}
	public void setFilms(Set<Film> films) {
		this.films = films;
	}
}
