package com.tuanfou.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.AreaInfo;
import com.tuanfou.service.AreaService;

public class AreaAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest req;
	private HttpServletResponse response;
	private static AreaService areaService = new AreaService();
	
	public String loadAreas(){
		req = (HttpServletRequest) ActionContext.getContext().get("request");
		response = ServletActionContext.getResponse();
		int cityId = Integer.parseInt(req.getParameter("cityId"));
		try{
			List<AreaInfo> areaInfoList = areaService.getAreaInfoList(cityId);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String res = gson.toJson(areaInfoList);
			out.print(res);
			return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return "LoadAreaSuccess";
		}
	}

}
