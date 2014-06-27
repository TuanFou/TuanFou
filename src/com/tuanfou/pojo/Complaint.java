package com.tuanfou.pojo;

public class Complaint {
	private int id;
	private GroupFilm groupFilm;
	private User user;
	private String reason;
	
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
