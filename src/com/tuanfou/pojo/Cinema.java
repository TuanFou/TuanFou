package com.tuanfou.pojo;

import java.util.Set;

public class Cinema {
	private int id;
	private String cinemaName;
	private String phoneNumber;
	private String description;
	private Area area;
	private String address;
	private Merchant merchant;
	private Set<GroupFilm> groupFilms;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public Set<GroupFilm> getGroupFilms() {
		return groupFilms;
	}
	public void setGroupFilms(Set<GroupFilm> groupFilms) {
		this.groupFilms = groupFilms;
	}	
}
