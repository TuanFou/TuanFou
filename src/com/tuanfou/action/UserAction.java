package com.tuanfou.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;


import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.ComplaintInfo;
import com.tuanfou.dto.MessageInfo;
import com.tuanfou.dto.MyCommentInfo;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.pojo.Account;
import com.tuanfou.pojo.City;
import com.tuanfou.pojo.Comment;
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
	private UserService userService;
	@SuppressWarnings("unused")
	private List<User>  userList;
	private List<MyHeartGroupFilmInfo> myHeartFilm;
	private Set<MyCommentInfo> comments;
	private List<ComplaintInfo> complaints;
	private List<MessageInfo> messages;
	
	public List<MessageInfo> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageInfo> messages) {
		this.messages = messages;
	}
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
	public void setComments(Set<MyCommentInfo> comments){
		this.comments = comments;
	}
	public Set<MyCommentInfo> getComments(){
		return comments;
	}
	public List<ComplaintInfo> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<ComplaintInfo> complaints) {
		this.complaints = complaints;
	}
	/**
	 * 用户登录
	 * 参数：用户名username;密码password
	 */
	public String login(){
		
		String matching = ERROR;
		req = ServletActionContext.getRequest();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try{

			Session session = HibernateUtil.getSession();
			String hql = "from User user where user.userName=:username and user.password=:password";
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<User> userList = query.list();
			Iterator<User> itUser =userList.iterator();
			if(itUser.hasNext())
				{			
					matching = SUCCESS;
				}
		}catch(Exception e){
			e.printStackTrace();
			matching = ERROR;
		}finally{
			HibernateUtil.closeSession();
		}
		return matching;
	}
	
	/**
	 *注册新用户
	 *参数：用户名username;密码password;城市ID cityId
	 */
	public boolean regist(){
		boolean res = true;
		req = ServletActionContext.getRequest();
		User aUser = new User();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//cityId 要获取参数值
		int cityId = 31901;
		aUser.setUserName(username);
		aUser.setPassword(password);
		try{
			UserService us = new UserService();
			List<User> userList = us.getUserList();
			Iterator<User> itUser =userList.iterator();
			
			while(itUser.hasNext())
			{			
				if(itUser.next().getUserName().equals(username)){
					res = false;
				}
			}
		
			if(res) {
				City city = new City();
				city.setId(cityId);
				aUser.setCity(city);
				Account account = new Account();
				account.setBalance(0);
				us.addAccount(account);
				Session session = HibernateUtil.getSession();
				@SuppressWarnings("unchecked")
				List<Account> accountList = session.createQuery("from Account account where account.id=(select max(a.id) from Account a)").list();
				Iterator<Account> itAccount =accountList.iterator();
				while(itAccount.hasNext())
				{			
					aUser.setAccount(itAccount.next());
				}
				us.addUser(aUser);  
			}
			
		}catch(Exception e){
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
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
	public String showMyComment(){
		int id = 302010010;
		UserService userService = new UserService();
		comments = userService.getMyComments(id);
		if(comments == null)
			return "error";
		else
			return "myComment";
	}
	public String showMyComplaint(){
		int id = 302010010;
		UserService userService = new UserService();
		complaints = userService.getMyComplaints(id);
		if(complaints == null)
			return "error";
		else
			return "myComplaint";
	}
	
	public String showMyMessage(){
		int id = 302010010;
		UserService userService = new UserService();
		messages = userService.getMyMessages(id );
		Gson gson = new Gson();
		String result = gson.toJson(messages);
		System.out.println(result);
		if(messages == null)
			return "error";
		else
			return "myMessage";
	}
	
}
