package com.tuanfou.pojo;

import java.util.Set;

public class City {
	private int id;
	private String cityName;
    private Set<Area> areas;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Set<Area> getAreas() {
		return areas;
	}
	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}
}
