package com.tuanfou.pojo;

import java.util.Set;

public class Merchant {
	private int id;
	private String merchantName;
	private String password;
	private String idNumber;
	private String photoUrl;
	private Set<Film> films;
	private Set<Cinema> cinemas;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Set<Film> getFilms() {
		return films;
	}
	public void setFilms(Set<Film> films) {
		this.films = films;
	}
	public Set<Cinema> getCinemas() {
		return cinemas;
	}
	public void setCinemas(Set<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
}
