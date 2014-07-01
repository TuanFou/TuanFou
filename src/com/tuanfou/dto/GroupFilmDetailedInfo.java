package com.tuanfou.dto;


import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.tuanfou.pojo.Tag;

public class GroupFilmDetailedInfo {
	private float currentPrice;
	private int partnerNum;//the num of the members who want to watch film with others
	private String cinemaName;
	private String cinemaAddress;
	private Date endDate;//tickets can only be used before this date
	private Time timeRange;//tickets can only be used in the time range, like 10:00-24:00
	private int orderNum;//
	private float groupfilmStar;
	private int commentNum;
	private int filmStar;
	private String description;
	private String filmName;
	private int period;//in minutes
	private List<Tag> tags;
	private Date realeaseDate;
	private String director;
	
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getPartnerNum() {
		return partnerNum;
	}
	public void setPartnerNum(int partnerNum) {
		this.partnerNum = partnerNum;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getCinemaAddress() {
		return cinemaAddress;
	}
	public void setCinemaAddress(String cinemaAddress) {
		this.cinemaAddress = cinemaAddress;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Time getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(Time timeRange) {
		this.timeRange = timeRange;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public float getGroupfilmStar() {
		return groupfilmStar;
	}
	public void setGroupfilmStar(float groupfilmStar) {
		this.groupfilmStar = groupfilmStar;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getFilmStar() {
		return filmStar;
	}
	public void setFilmStar(int filmStar) {
		this.filmStar = filmStar;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public Date getRealeaseDate() {
		return realeaseDate;
	}
	public void setRealeaseDate(Date realeaseDate) {
		this.realeaseDate = realeaseDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

}
