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
	private int orderNum;
	private float groupfilmStar;
	private int commentNum;
	private int filmStar;
	private String description;
	private String filmName;
	private int period;//in minutes
	private List<Tag> tags;
	private Date realeaseDate;
	private String director;
	
	
	public float getPrice() {
		return currentPrice;
	}
	public void setPrice(float price) {
		this.currentPrice = price;
	}
	public int getGroupMemberNum() {
		return partnerNum;
	}
	public void setGroupMemberNum(int groupMemberNum) {
		this.partnerNum = groupMemberNum;
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
	public Date getDeadline() {
		return endDate;
	}
	public void setDeadline(Date deadline) {
		this.endDate = deadline;
	}
	public Time getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(Time timeRange) {
		this.timeRange = timeRange;
	}
	public int getorderNum() {
		return orderNum;
	}
	public void setorderNum(int orderNum) {
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
	public String getSummary() {
		return description;
	}
	public void setSummary(String summary) {
		this.description = summary;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public int getFilmLength() {
		return period;
	}
	public void setFilmLength(int filmLength) {
		this.period = filmLength;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public Date getShowDate() {
		return realeaseDate;
	}
	public void setShowDate(Date showDate) {
		this.realeaseDate = showDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

}
