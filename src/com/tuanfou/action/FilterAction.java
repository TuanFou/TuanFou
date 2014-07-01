package com.tuanfou.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.AreaInfo;
import com.tuanfou.dto.TagInfo;
import com.tuanfou.service.AreaService;
import com.tuanfou.service.TagService;

public class FilterAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private TagService tagService;
	private AreaService areaService;
	private String city;
	private List<AreaInfo> areas;
	private List<TagInfo> filmTags;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<AreaInfo> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaInfo> areas) {
		this.areas = areas;
	}

	public List<TagInfo> getFilmTags() {
		return filmTags;
	}

	public void setFilmTags(List<TagInfo> filmTags) {
		this.filmTags = filmTags;
	}

	/*
	 * 获取过滤标签
	 */
	public String getFilterTags(){
		city = "武汉";
		tagService = new TagService();
		areaService = new AreaService();
		try{
			filmTags = tagService.getTagInfoList();
			areas = areaService.getAreaInfoList(2);
			return "home";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
	}
}
