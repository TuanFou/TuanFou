package com.tuanfou.pojo;

import java.util.Date;

public class Order {
	private int id;
	private int groupFilmId;
	private int userId;
	private Date createTime;
	private Date expiredTime;
	private int status;
	
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpiredTime() {
		return expiredTime;
	}
	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
