package com.tuanfou.pojo;

import java.sql.Date;

public class Order {
	private int id;
	private GroupFilm groupFilm;
	private User user;
	private Date createTime;
	private Date expiredTime;
	private int status;  //订单状态，0：失效，1：未支付，2：已经支付
	
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
