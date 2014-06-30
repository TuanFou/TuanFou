package com.tuanfou.pojo;


import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

public class Film {
	private int id;
	//private int merchantId;
	private Merchant merchant;
	private String filmName;
	private Date releaseDate;
	private String version;
	private String country;
	private int period; //∑÷÷”
	private String description;
	private String director;
	private String actors;
	private int star; //0,1,2,3,4,5
	private int status;//0£∫…Û∫À÷–£¨1£∫…Û∫À÷–£¨2£∫…Û∫ÀŒ¥Õ®π˝
	private Timestamp applicateTime;//2014-09-12 12:00:00
	private int auditResult; //…Û∫À◊¥Ã¨£∫1£¨…Û∫ÀÕ®π˝£¨2£∫…Û∫ÀŒ¥Õ®π˝
	private Set<Tag> tags;
	private Set<GroupFilm> groupFilms;
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
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
	public Date getApplicateTime() {
		return applicateTime;
	}
	public void setApplicateTime(Timestamp applicateTime) {
		this.applicateTime = applicateTime;
	}
	public int getAuditResult() {
		return auditResult;
	}
	public void setAuditResult(int auditResult) {
		this.auditResult = auditResult;
	}
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<GroupFilm> getGroupFilms() {
		return groupFilms;
	}
	public void setGroupFilms(Set<GroupFilm> groupFilms) {
		this.groupFilms = groupFilms;
	}
}
