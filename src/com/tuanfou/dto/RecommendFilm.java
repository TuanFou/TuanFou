package com.tuanfou.dto;

public class RecommendFilm {

	private int groupFilmId;    //团购电影id；
	private int rank;
	private String picUrl;
	private String filmName;    //电影名称
	private String cinemaName;  //影院名称
	private int userNum;        //想看人数
	
	public int getGroupFilmId() {
		return groupFilmId;
	}
	public void setGroupFilmId(int groupFilmId) {
		this.groupFilmId = groupFilmId;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
