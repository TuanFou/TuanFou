package com.tuanfou.dto;

import java.util.Date;

public class OrderInfo {
	 private int orderId;//订单id
	 private int groupFilmId;
	 private String cinemaName;
	 private Date orderTime;
	 private String filmName;//团购电影名字
	 private float curretPrice;//团购电影价格
	 private float originalPrice;//打折前价格
	 private int amount;//购买数量
	 private float  totalPrice;
	 private String status;//订单状态订单状态,0：失效，1：未支付，2：已经支付
	 private String filmPhoto;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public float getCurretPrice() {
		return curretPrice;
	}
	public void setCurretPrice(float curretPrice) {
		this.curretPrice = curretPrice;
	}
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFilmPhoto() {
		return filmPhoto;
	}
	public void setFilmPhoto(String filmPhoto) {
		this.filmPhoto = filmPhoto;
	}
	public int getGroupFilmId() {
		return groupFilmId;
	}
	public void setGroupFilmId(int groupFilmId) {
		this.groupFilmId = groupFilmId;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	 
}
