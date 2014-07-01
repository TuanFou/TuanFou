package com.tuanfou.dto;


import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.tuanfou.pojo.Tag;

public class GroupFilmDetailedInfo {
	private float price;
	private int groupMemberNum;//the num of the members who want to watch film with others
	private String cinemaName;
	private String cinemaAddress;
	private Date deadline;//tickets can only be used before this date
	private Time timeRange;//tickets can only be used in the time range, like 10:00-24:00
	private int orderNum;//
	private float groupfilmStar;
	private int commentNum;
	private int filmStar;
	private String summary;
	private String filmName;
	private int filmLength;
	private List<Tag> tags;
	private Date showDate;
	private String director;
	
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getGroupMemberNum() {
		return groupMemberNum;
	}
	public void setGroupMemberNum(int groupMemberNum) {
		this.groupMemberNum = groupMemberNum;
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
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
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
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public int getFilmLength() {
		return filmLength;
	}
	public void setFilmLength(int filmLength) {
		this.filmLength = filmLength;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

}
