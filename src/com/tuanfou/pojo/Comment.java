package com.tuanfou.pojo;

import java.sql.Date;


public class Comment {
	private int id;
	private GroupFilm groupFilm;
	private User user;
	private Date createTime;	//此处Date类型对应mysql中datetime
	private String content;
	private int star;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GroupFilm getGroupFilm() {
		return groupFilm;
	}
	public void setGroupFilm(GroupFilm groupFilm) {
		this.groupFilm = groupFilm;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date date) {
		this.createTime = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
}
