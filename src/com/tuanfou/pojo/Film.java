package com.tuanfou.pojo;

import java.sql.Date;
import java.sql.Time;

public class Film {
	private int merchantId;
	private String filmName;
	private Date releaseDate;
	private String version;
	private String country;
	private int period;
	private String description;
	private String director;
	private String actors;
	private int star;
	private int status;
	private Time applicateTime;
	private int auditResult;
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Time getApplicateTime() {
		return applicateTime;
	}
	public void setApplicateTime(Time applicateTime) {
		this.applicateTime = applicateTime;
	}
	public int getAuditResult() {
		return auditResult;
	}
	public void setAuditResult(int auditResult) {
		this.auditResult = auditResult;
	}
}
