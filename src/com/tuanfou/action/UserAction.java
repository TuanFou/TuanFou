package com.tuanfou.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.pojo.User;
import com.tuanfou.service.OrderService;
import com.tuanfou.service.UserService;

public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ��¼����
	 * @return �Ƿ�ɹ�
	 */
	private User user;
	
	@SuppressWarnings("unused")
	private HttpServletRequest req;
	private HttpServletResponse response;
	private UserService userService;
	@SuppressWarnings("unused")
	private List<User>  userList;
	private List<MyHeartGroupFilmInfo> myHeartFilm;
	
	public List<MyHeartGroupFilmInfo> getMyHeartFilm() {
		return myHeartFilm;
	}
	public void setMyHeartFilm(List<MyHeartGroupFilmInfo> myHeartFilm) {
		this.myHeartFilm = myHeartFilm;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/*
	 * ��¼�û�
	 */
	public String login(){
		UserService service = new UserService();
		if(service.addUser(user)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String regist(){
		return SUCCESS;
	}
	/*
	 * ��ȡ�û��б�href="UserAction!getUserList"
	 */
	public void getUserList() throws IOException{
		userList = new ArrayList<User>();
		response =  ServletActionContext.getResponse();
		userService = new UserService();
		userList = userService.getUserList();
		PrintWriter  out = response.getWriter();
		out.print("hello");
	}
	
	/**
	 * 下订单
	 * 参数：团购电影id，用户id，团购到期时间，
	 */
	public String order(int groupFilmId,int userId,Date expiredTime){
		OrderService orderService = new OrderService();
		if(orderService.orderFilm(groupFilmId, userId, expiredTime))
			return "OrderSuccess";
		else
			return "OrderFailure";
	}
	/*
	 * 功能：显示用户个人主页首页
	 */
	public String ShowProfilePage(){
		//通过session获取用户id
		int id = 304010333;
		UserService userService = new UserService();
		user = userService.getUserInfo(id); 
		if(user==null){
			return "error";
		}else{
			return "userHome";
		}
	}
	/*
	 * 显示个人信息
	 */
	public String showUserInfo(){
		//通过Session获取id
		int id = 304010333;
		UserService userService = new UserService();
		user = userService.getUserInfo(id); 
		if(user==null){
			return "error";
		}else{
			return "personInfo";
		}
	}
	public String showMyHeartFilmInfo(){
		int id = 302010010;
		UserService userService = new UserService();
		myHeartFilm = userService.getHeartFilmByUserId(id);
		if(myHeartFilm==null)
			return "error";
		return "myHeartFilm";	
	}
}
