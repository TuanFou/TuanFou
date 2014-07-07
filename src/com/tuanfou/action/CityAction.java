package com.tuanfou.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.service.CityService;

public class CityAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	/*
	 * 获取城市列表
	 */
	public void listCities() throws IOException{
		CityService cityService = new CityService();
		Map<Integer,String> list = cityService.listCities();
		Gson gson = new Gson();
		String str = gson.toJson(list);
		response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(str);
	}

}
