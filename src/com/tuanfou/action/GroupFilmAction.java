package com.tuanfou.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.dto.GroupFilmDetailedInfo;
import com.tuanfou.dto.RecommendFilm;
import com.tuanfou.service.GroupFilmService;

public class GroupFilmAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest req;
	private HttpServletResponse response;
	private GroupFilmDetailedInfo groupFilmDetailInfo;
	
	public GroupFilmDetailedInfo getGroupFilmDetailInfo() {
		return groupFilmDetailInfo;
	}
	public void setGroupFilmDetailInfo(GroupFilmDetailedInfo groupFilmDetailInfo) {
		this.groupFilmDetailInfo = groupFilmDetailInfo;
	}
	
	public String showGroupFilmDetail(){
		req = ServletActionContext.getRequest();
		int id = Integer.parseInt(req.getParameter("groupFilmId"));
		try{
			GroupFilmService gs = new GroupFilmService();
			groupFilmDetailInfo = gs.getGroupFilmDetailInfo(id);
			return "detailInfo";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "error";
	}
	/*
	 * ���ظ�࣬ʵ�ַ�ҳ��ʾ
	 */
	public String loadMore() throws IOException{
		req = ServletActionContext.getRequest();
		int page = Integer.parseInt( req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		int fistResult = (page-1)*pageSize;
		try{
			GroupFilmService gs = new GroupFilmService();
			List<GroupFilmBriefInfo> groupFilms = gs.loadGroupFilmsBriefInfo(fistResult, pageSize);
			response =  ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter  out = response.getWriter();
			Gson gson = new Gson();
			String res = gson.toJson(groupFilms);
			out.print(res);
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	/*
	 * 获取推荐列表
	 * 推荐前五个
	 */
	public String getRecommendGroupFilms(){
		req = ServletActionContext.getRequest();
		int page = Integer.parseInt( req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		//int fistResult = (page-1)*pageSize;
		try{
			GroupFilmService gs = new GroupFilmService();
			List<RecommendFilm> groupFilms = gs.getRecommendFilms(pageSize,page);
			response =  ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter  out = response.getWriter();
			Gson gson = new Gson();
			String res = gson.toJson(groupFilms);
			out.print(res);
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
}
