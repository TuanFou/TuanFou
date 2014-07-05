package com.tuanfou.dto;

import java.util.Map;

/**
 * 商家填写申请电影信息
 * @author LN
 *
 */
public class ApplyFilmInfo {
	private int merchantId;        //商家id
	private String fileName;       //电影名称
	private String releaseTime;    //电影发布时间
	private String version;        //电影版本
	private String country;        //电影产地
	private int period;            //时长
	private String description;    //描述
	private String director;       //导演
	private String actor;          //演员
	int star;              //星级
	private Map<Integer,String> tags;
	
	public Map<Integer, String> getTags() {
		return tags;
	}
	public void setTags(Map<Integer, String> tags) {
		this.tags = tags;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	
}
