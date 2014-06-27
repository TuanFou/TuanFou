package com.tuanfou.pojo;

import java.util.Set;

public class User {
	private int id;       //�û�id
	private Account account;
	private String userName;  //�û���
	private String password;  //����
	private String email; //����
	private City city;//����
	private String description;
	private String photoUrl;
	private Set<Comment> commeents;
	private Set<Complaint> complaints;
	private Set<GroupFilm> heartGroupFilm;//�뿴�ĵ�Ӱ
	private Set<Order> orders;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Comment> getCommeents() {
		return commeents;
	}
	public void setCommeents(Set<Comment> commeents) {
		this.commeents = commeents;
	}
	public Set<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}
	public Set<GroupFilm> getHeartGroupFilm() {
		return heartGroupFilm;
	}
	public void setHeartGroupFilm(Set<GroupFilm> heartGroupFilm) {
		this.heartGroupFilm = heartGroupFilm;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
}
