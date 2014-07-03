package com.tuanfou.dto;

public class TagInfo {
	private int tagId;       //tagId
	private String tagName;  //标签名称
	private int filmNum;    //有此标签的团购电影数量
	
	public TagInfo(){
		
	}
	public TagInfo(String tagName,int filmNum){
		setTagName(tagName);
		setFilmNum(filmNum);
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getFilmNum() {
		return filmNum;
	}
	public void setFilmNum(int filmNum) {
		this.filmNum = filmNum;
	}
}
