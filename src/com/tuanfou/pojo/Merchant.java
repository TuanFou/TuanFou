package com.tuanfou.pojo;

public class Merchant {
	private int id;
	private String merchantName;
	private String password;
	private String idNumber;
	private String photoUrl;
	private int cinemaId;
	
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
	public int getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}
	
}
