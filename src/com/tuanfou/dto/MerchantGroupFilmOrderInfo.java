package com.tuanfou.dto;

import java.util.Date;

public class MerchantGroupFilmOrderInfo {
	private int id;
	private String filmName;
	private String address;
	private Date startDate;
	private Date endDate;
	private float originPrice;
	private float currentPrice;
	private int heartNum;
	private int orderNum;
	private int type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public float getOriginPrice() {
		return originPrice;
	}
	public void setOriginPrice(float originPrice) {
		this.originPrice = originPrice;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getHeartNum() {
		return heartNum;
	}
	public void setHeartNum(int heartNum) {
		this.heartNum = heartNum;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
