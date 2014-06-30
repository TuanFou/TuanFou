package com.tuanfou.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dto.GroupFilmBriefInfo;

public class GroupFilmAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest req;
	private HttpServletResponse response;
	private static GroupFilmDao groupFimDao = new GroupFilmDao();
	/*
	 * 加载更多，实现分页显示
	 */
	public String loadMore() throws IOException{
		req = ServletActionContext.getRequest();
		int page = Integer.parseInt( req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		int fistResult = (page-1)*pageSize;
		try{
			List<GroupFilmBriefInfo> groupFilms = groupFimDao.getGroupFilmsBriefInfo(fistResult, pageSize);
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
