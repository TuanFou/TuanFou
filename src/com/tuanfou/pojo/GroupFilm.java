package com.tuanfou.pojo;


import java.util.Date;
import java.util.Set;

public class GroupFilm {
	private int id;
	private Film  film;
	private Merchant merchant;
	private Area area;
	private Cinema cinema;
	private float currentPrice;//���ۺ�ļ۸�
	private float originalPrice;//����ǰ�ļ۸�
	private Date startDate;
	private Date endDate;
	private int status;  //0:�����У�1:���ϼܣ�2���¼�
	private String remark;//��ע
	private int type;//0:�Ѿ���ӳ, 1��������ӳ��2���¼�
	private String picUrl;//图片路径
	private Set<User> users;//�뿴�û�
	private Set<Comment> comments;
	private Set<Complaint> complaints;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
