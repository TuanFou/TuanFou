package com.tuanfou.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;


import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tuanfou.dto.ComplaintInfo;
import com.tuanfou.dto.MessageInfo;
import com.tuanfou.dto.MyCommentInfo;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.pojo.City;
import com.tuanfou.pojo.User;
import com.tuanfou.service.CommentService;
import com.tuanfou.service.OrderService;
import com.tuanfou.service.UserService;;

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
	
	private HttpServletRequest req;
	private HttpServletResponse response;
	private Map<String ,Object> session;
	private UserService userService;
	private Set<MyCommentInfo> comments;
	private List<ComplaintInfo> complaints;
	private List<MessageInfo> messages;
	@SuppressWarnings("unused")
	private List<User>  userList;
	private List<MyHeartGroupFilmInfo> myHeartFilm;
//	private File filmFile;//上传的头像
//    private String fileName; //上传文件名
//    
//    public void setFilmFileFileName(String fileName)  {
//        System.out.println("FileName : " + fileName);
//           this .fileName = fileName;
//    } 
//          
	
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
	public Set<MyCommentInfo> getComments() {
		return comments;
	}
	public void setComments(Set<MyCommentInfo> comments) {
		this.comments = comments;
	}
	public List<ComplaintInfo> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<ComplaintInfo> complaints) {
		this.complaints = complaints;
	}
	public List<MessageInfo> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageInfo> messages) {
		this.messages = messages;
	}

	/**
	 * 用户登录
	 * 参数：用户名username;密码password
	 * @throws IOException 
	 */
	public String login() throws IOException{
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
			session.put("userId", id);
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
		user.setPhotoUrl("/TuanFou/imgs/girl2.jpg");
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
		session = ActionContext.getContext().getSession();
		int id =  (Integer) session.get("userId");
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
		session = ActionContext.getContext().getSession();
		int id =  (Integer) session.get("userId");
		UserService userService = new UserService();
		user = userService.getUserInfo(id); 
		if(user==null){
			return "error";
		}else{
			return "personInfo";
		}
	}
	public String showMyHeartFilmInfo(){
		session = ActionContext.getContext().getSession();
		int id =  (Integer) session.get("userId");
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
	public String showMyComment(){
		session = ActionContext.getContext().getSession();
		int id =  (Integer) session.get("userId");
		UserService userService = new UserService();
		comments = userService.getMyComments(id);
		if(comments == null)
			return "error";
		else
			return "myComment";
	}
	public String showMyComplaint(){
		session = ActionContext.getContext().getSession();
		int id =  (Integer) session.get("userId");
		UserService userService = new UserService();
		complaints = userService.getMyComplaints(id);
		if(complaints == null)
			return "error";
		else
			return "myComplaint";
	}
	
	public String showMyMessage(){
		session = ActionContext.getContext().getSession();
		int id =  (Integer) session.get("userId");
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
	/*
	 * 用户发表评论
	 */
	public void addComment() throws IOException{
		session = ActionContext.getContext().getSession();
		req = ServletActionContext.getRequest();
		response =  ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter  out = response.getWriter();
		
		int userId = (Integer) session.get("userId");
		int groupFilmId = Integer.valueOf(req.getParameter("groupFilmId"));
		String content = req.getParameter("content");
		int star = Integer.parseInt(req.getParameter("star"));
		System.out.println(star+";"+groupFilmId);
		CommentService commentService = new CommentService();
		if(commentService.postComment(groupFilmId, userId, content, star)){
			out.print("success");		
		}else{
			out.print("error");
		}
	}
}
