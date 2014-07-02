package com.tuanfou.dto;

public class AreaInfo {
	private int areaId;       //地区ID
	private String areaName;  //地区名称
	private int filmNumber;   //该地区团购电影数量
	
	public AreaInfo(){
		
	}
	public AreaInfo(String areaName,int filmNumber){
		setAreaName(areaName);
		setFilmNumber(filmNumber);
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getFilmNumber() {
		return filmNumber;
	}
	public void setFilmNumber(int filmNumber) {
		this.filmNumber = filmNumber;
	}
	

}
