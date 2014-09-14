package com.tuanfou.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.service.MessageService;

public class MessageAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest req;
	private HttpServletResponse response;
	/*
	 * 发送以下消息
	 */
	public void sendMessage() throws IOException{
		req = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		int senderId = Integer.parseInt(req.getParameter("senderId"));
		int receiverId = Integer.parseInt(req.getParameter("receiverId"));
		String content = req.getParameter("content");
		System.out.println(content);
		int type = Integer.parseInt(req.getParameter("type"));
		
		MessageService messageService = new MessageService();
		PrintWriter out = response.getWriter();
		if(messageService.addMessage(senderId, receiverId, content, type)){
			out.print("success");
		}else{
			out.print("failed");
		}
	}
}
