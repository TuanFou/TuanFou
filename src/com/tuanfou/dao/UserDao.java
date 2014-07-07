package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.dto.CommentInfo;
import com.tuanfou.dto.ComplaintInfo;
import com.tuanfou.dto.MessageInfo;
import com.tuanfou.dto.MyCommentInfo;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.dto.OrderInfo;
import com.tuanfou.pojo.Account;
import com.tuanfou.pojo.Admin;
import com.tuanfou.pojo.Area;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Comment;
import com.tuanfou.pojo.Complaint;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Message;
import com.tuanfou.pojo.Order;
import com.tuanfou.pojo.User;
import com.tuanfou.utils.ComparatorComment;
import com.tuanfou.utils.ComparatorMyCommentInfo;
import com.tuanfou.utils.HibernateUtil;

public class UserDao {
	private Session session = null;
	
	/*
	 * ���һ���û�
	 */
	public boolean addUser(User user){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(user);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("����û�ʧ��");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
	/*
	 * ��ȡ�û��б�
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUserList(){
		List<User> userList = new ArrayList<User>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from User user";
			Query q = session.createQuery(hql);
			userList = q.list();
		}catch(Exception e){
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return userList;	
	}
	/**
	 * 获得用户的所有评论
	 * @param id
	 * @return
	 */
	public Set<MyCommentInfo> getUserComments(int id){
		Set<MyCommentInfo> userComments = new HashSet<MyCommentInfo>();
		try{
			session = HibernateUtil.getSession();
			User user = (User)session.get(User.class, new Integer(id));
			Set<Comment> comments = user.getComments();
			for(Iterator<Comment> it =comments.iterator(); it.hasNext(); ){
				Comment aComment = (Comment)it.next();
				MyCommentInfo commentInfo = new MyCommentInfo();
				commentInfo.setContent(aComment.getContent());
				GroupFilm groupFilm = aComment.getGroupFilm();
				commentInfo.setPicUrl(groupFilm.getPicUrl());
				commentInfo.setFilmName(groupFilm.getFilm().getFilmName());
				commentInfo.setCinemaName(groupFilm.getCinema().getCinemaName());
				commentInfo.setTime(aComment.getCreateTime());
				userComments.add(commentInfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		userComments = sortCommentDes(userComments);
		return userComments;
	}
	
	/**
	 * Sort the user's comments by the Date DES order
	 * @param userComments
	 * @return
	 */
	private Set<MyCommentInfo> sortCommentDes(Set<MyCommentInfo> userComments) {
		List<MyCommentInfo> list = new ArrayList<MyCommentInfo>();
		list.addAll(userComments);
		ComparatorMyCommentInfo com = new ComparatorMyCommentInfo();
		Collections.sort(list, com);
		userComments.addAll(list);
		return userComments;
	}
	//获得数据库对象
	public User getUser(int userId){
		try{
			session = HibernateUtil.getSession();
			User user = (User)session.get(User.class, userId);
			if(!Hibernate.isInitialized(user.getCity()))
				Hibernate.initialize(user.getCity());
			System.out.println("userAccount:"+user.getAccount().getBalance());
			return user;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	/**
	 * get the information for the targeted user's hearted GroupFilms
	 * @author yogiman
	 * @param id
	 * @return List<MyHeartGroupFilmInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<MyHeartGroupFilmInfo> getHeartGroupFilms(int id){
		List<GroupFilm> groupFilmList = new ArrayList<GroupFilm>();		
		List<MyHeartGroupFilmInfo> myInfoList = new ArrayList<MyHeartGroupFilmInfo>();
		try{
			String hql = "select heartGroupFilm from User user where user.id = ";
			Integer integer = id;
			hql += integer.toString();
			session = HibernateUtil.getSession();
			Query query = session.createQuery(hql);
			//query.setParameter("id", id);
			groupFilmList = query.list();
			Iterator<GroupFilm> groupFilmListIterator = groupFilmList.iterator();
			while(groupFilmListIterator.hasNext()){
				GroupFilm groupFilm = groupFilmListIterator.next();
				MyHeartGroupFilmInfo myInfo = new MyHeartGroupFilmInfo();
				myInfo.setId(groupFilm.getId());
				myInfo.setFilmName(groupFilm.getFilm().getFilmName());
				myInfo.setAddress(groupFilm.getArea().getAreaName());
				myInfoList.add(myInfo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return myInfoList;
	}

	/*
	 * 获取用户的账户
	 */
	public Account getAccount(int userId){
		try{
			session = HibernateUtil.getSession();
			User user = (User) session.get(User.class, userId);
			Account account = new Account();
			account.setId(user.getAccount().getId());
			account.setBalance(user.getAccount().getBalance());
			return account;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	/*
	 * 查找用户名和密码是否存在
	 */
	public int findUser(String userName,String password){
		try{
			Session session = HibernateUtil.getSession();
			String hql = "from User user where user.userName=:username and user.password=:password";
			Query query = session.createQuery(hql);
			query.setParameter("username", userName);
			query.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<User> userList = query.list();
			Iterator<User> itUser =userList.iterator();
			if(itUser.hasNext())
			{							
				return itUser.next().getId();
			}else{
				return -1;
			}
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	/**
	 * 获取用户的所有的投诉
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ComplaintInfo> getUserComplaints(int userId){
		List<ComplaintInfo> complaintInfoList = new ArrayList<ComplaintInfo>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from Complaint complaint where complaint.user.id = :userId";
			//Integer integer = userId;
			Query query = session.createQuery(hql);
			query.setParameter("userId", userId);
			//hql += integer.toString();
			//List<Complaint> complaints = HibernateTemplate.executeQuery(hql, firstResult, maxResult);
			List<Complaint> complaints = query.list();
			Iterator<Complaint> iterator = complaints.iterator();
			while(iterator.hasNext()){
				Complaint complaint = iterator.next();
				GroupFilm groupFilm = complaint.getGroupFilm();
				Film film = groupFilm.getFilm();
				Area area = groupFilm.getArea();
				Cinema cinema = groupFilm.getCinema();
				ComplaintInfo complaintInfo = new ComplaintInfo();
				
				complaintInfo.setId(complaint.getId());
				complaintInfo.setGroupFilmId(complaint.getGroupFilm().getId());
				complaintInfo.setUserId(complaint.getUser().getId());
				complaintInfo.setReason(complaint.getReason());
				complaintInfo.setAreaName(area.getAreaName());
				complaintInfo.setCinemaName(cinema.getCinemaName());
				complaintInfo.setFilmName(film.getFilmName());
				complaintInfo.setPicUrl(groupFilm.getPicUrl());
				complaintInfoList.add(complaintInfo);				
			}
			return complaintInfoList;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MessageInfo> getUserMessages(int userId){
		List<MessageInfo> messageInfoList = new ArrayList<MessageInfo>();
		try{
			session = HibernateUtil.getSession();
			AdminDao adminDao = new AdminDao();
			UserDao userDao = new UserDao();
			String hql = "From Message message where message.receiverId=:userId";
			Query query = session.createQuery(hql);
			query.setParameter("userId", userId);
			List<Message> messageList = query.list();
			Iterator<Message> it = messageList.iterator();
			while(it.hasNext()){
				Message message = it.next();
				MessageInfo messageInfo = new MessageInfo();
				messageInfo.setContent(message.getContent());
				messageInfo.setMessageId(message.getId());
				messageInfo.setTime(message.getTime());
				messageInfo.setSenderId(message.getSenderId());
				if(message.getType() == 1){
					Admin admin = adminDao.getAdmin(message.getSenderId());
					messageInfo.setSenderName(admin.getName());
					messageInfo.setPhotoUrl("./imgs/girl.jpg");
				}
				if(message.getType() == 2){
					User user = userDao.getUser(message.getSenderId());
					messageInfo.setSenderName(user.getUserName());
					messageInfo.setPhotoUrl(user.getPhotoUrl());
				}
				messageInfoList.add(messageInfo);
			}
			return messageInfoList;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
		
	}
}
