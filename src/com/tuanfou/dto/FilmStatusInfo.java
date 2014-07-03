package com.tuanfou.dto;

public class FilmStatusInfo {
	private String status;     //团购电影状态，正在上映，即将上映
	private int filmNum;       //该类团购电影的数量
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
}
