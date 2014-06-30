package com.tuanfou.dto;

import java.util.List;

public class GroupFilmBriefInfo {
	private int GroupFilmId;
	private String filmName;
	private String filmPhotoUrl;
	private float star;//�Ź���Ӱ����
	private List<String> tags;
	private String cinemaName;
	private int  heartNum;
	private float currentPrice;
	private float originalPrice;
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public int getHeartNum() {
		return heartNum;
	}
	public void setHeartNum(int heartNum) {
		this.heartNum = heartNum;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}
	public int getGroupFilmId() {
		return GroupFilmId;
	}
	public void setGroupFilmId(int groupFilmId) {
		GroupFilmId = groupFilmId;
	}
	public String getFilmPhotoUrl() {
		return filmPhotoUrl;
	}
	public void setFilmPhotoUrl(String filmPhotoUrl) {
		this.filmPhotoUrl = filmPhotoUrl;
	}
}
