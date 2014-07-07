package com.tuanfou.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.pojo.Account;
import com.tuanfou.pojo.City;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.User;
import com.tuanfou.service.CommentService;
import com.tuanfou.service.GroupFilmService;
import com.tuanfou.service.OrderService;
import com.tuanfou.service.UserService;
import com.tuanfou.utils.HibernateUtil;
import com.tuanfou.utils.Utils;

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
	private Map<String ,Object> session;
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

	/**
	 * 用户登录
	 * 参数：用户名username;密码password
	 * @throws IOException 
	 */
	public String login() throws IOException{
		
		String matching = ERROR;
		req = ServletActionContext.getRequest();
		req.setCharacterEncoding("utf-8");
		session = ActionContext.getContext().getSession();
		response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		String username = req.getParameter("userName");
		String password = req.getParameter("password");
		UserService userService = new UserService();
		int id = userService.findUser(username, password);
		if(id!=-1){
			session.put("userName", username);
			session.put("userId", password);
			out.print("success");
		}else{
			out.print("error");
		}
		return null;
	}
	/**
	 *注册新用户
	 *参数：用户名username;密码password;城市ID cityId
	 * @throws IOException 
	 */
	public void regist() throws IOException{
		response =  ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		req = ServletActionContext.getRequest();
		req.setCharacterEncoding("utf-8");
		int cityId = Integer.parseInt(req.getParameter("cityId"));
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String description = req.getParameter("description");
		City city = new City();
		city.setId(cityId);
		User user = new User();
		user.setCity(city);
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setDescription(description);
		
		UserService userService = new UserService();
		if(userService.addUser(user)){
			session = ActionContext.getContext().getSession();
			session.put("userName", user.getUserName());
			session.put("userId", user.getId());
			out.print("success");
		}else{
			out.print("failed");
		}
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
	public String order(int groupFilmId,int userId,int amount){
		OrderService orderService = new OrderService();
		if(orderService.orderFilm(groupFilmId, userId, amount)!=-1)
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
	/*
	 * 退出登录
	 */
	public void logout() throws IOException{
		session = ActionContext.getContext().getSession();
		session.clear();
		response = ServletActionContext.getResponse();
		PrintWriter out  = response.getWriter();
		out.print("success");
	}
}
