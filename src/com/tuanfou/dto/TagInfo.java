package com.tuanfou.dto;


import java.util.Set;

import com.tuanfou.pojo.Film;

public class TagInfo {
	private int tagId;
	private String tagName;
	private int filmNum;
	private Set<Film> films;
	
	public TagInfo(){
		
	}
	public TagInfo(String tagName,int filmNum){
		setTagName(tagName);
		setFilmNum(filmNum);
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
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
