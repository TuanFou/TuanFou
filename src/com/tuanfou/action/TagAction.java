package com.tuanfou.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.TagInfo;
import com.tuanfou.service.TagService;

public class TagAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private TagService tagService = new TagService();
	
	/**
	 * 加载标签和各标签的电影数量
	 */
	public String loadTags(){
		response = ServletActionContext.getResponse();
		try{
			List<TagInfo> tagInfoList = tagService.getTagInfoList();
			Gson gson = new Gson();
			String res = gson.toJson(tagInfoList);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(res);
			return "LoadTagSuccess";
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	
}
