package com.tuanfou.pojo;

import java.sql.Date;

public class Comment {
	private int id;
	private int groupFilmId;
	private int userId;
	private Date createTime;	//此处Date类型对应mysql中datetime
	private String content;
	private int star;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupFilmId() {
		return groupFilmId;
	}
	public void setGroupFilmId(int groupFilmId) {
		this.groupFilmId = groupFilmId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
