﻿package com.tuanfou.dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.jasper.tagplugins.jstl.core.When;
import org.hibernate.Query;
import org.hibernate.Session;

import sun.print.resources.serviceui;

import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.dto.GroupFilmDetailedInfo;
import com.tuanfou.dto.InvitedMember;
import com.tuanfou.pojo.Comment;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Order;
import com.tuanfou.pojo.Tag;
import com.tuanfou.pojo.User;
import com.tuanfou.utils.HibernateTemplate;
import com.tuanfou.utils.HibernateUtil;

public class GroupFilmDao {
	private Session session = null;
	/*
	 * 锟斤拷锟斤拷殴锟斤拷锟接�
	 */
	public boolean addGroupFilm(GroupFilm groupFilm){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(groupFilm);
			session.getTransaction().commit();
			res = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
	/*
	 * 锟斤拷取锟脚癸拷锟斤拷息,只锟斤拷锟叫筹拷
	 */
	public List<GroupFilm> getGroupFilms(int firstResult,int maxResult){
		String hql = "from GroupFilm groupFilm where groupFilm.id = 1";
		List<GroupFilm> groupFilms  =  HibernateTemplate.executeQuery(hql, firstResult, maxResult);
		return groupFilms;	
	}
	
	/**
	 * 锟斤拷取锟脚癸拷锟斤拷影锟斤拷锟斤拷锟斤拷息锟斤拷锟斤拷锟杰伙拷取锟斤拷锟斤拷
	 */ 
	public List<GroupFilmBriefInfo> getGroupFilmsBriefInfo(int firstResult,int maxResult){
		List<GroupFilmBriefInfo> list = new ArrayList<GroupFilmBriefInfo>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from GroupFilm groupFilm";
			Query q = session.createQuery(hql);
			q.setFirstResult(firstResult);
			q.setMaxResults(maxResult);
			@SuppressWarnings("unchecked")
			List<GroupFilm> groupFilms  = q.list();
			Iterator<GroupFilm> it = groupFilms.iterator();
			while(it.hasNext()){
				GroupFilm groupFilm = it.next();
				GroupFilmBriefInfo briefInfo = new GroupFilmBriefInfo();
				briefInfo.setCinemaName(groupFilm.getCinema().getCinemaName());
				briefInfo.setCurrentPrice(groupFilm.getCurrentPrice());
				briefInfo.setOriginalPrice(groupFilm.getOriginalPrice());
				briefInfo.setGroupFilmId(groupFilm.getId());
				//锟斤拷取锟斤拷影锟斤拷锟斤拷息
				Film film = groupFilm.getFilm();
				briefInfo.setFilmName(film.getFilmName());
				briefInfo.setHeartNum(groupFilm.getUsers().size());
				briefInfo.setFilmPhotoUrl(groupFilm.getPicUrl());
				//锟斤拷取锟斤拷签
				Set<Tag> tags = film.getTags();
				List<String> tagList = new ArrayList<String>();
				for(Tag tag:tags){
					tagList.add(tag.getTagName());
				}
				briefInfo.setTags(tagList);
				list.add(briefInfo);			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public GroupFilmDetailedInfo getGroupFilmDetailedInfo(int id){
		GroupFilmDetailedInfo groupFilmDetailedInfo=new GroupFilmDetailedInfo();
		try{
			session = HibernateUtil.getSession();
			String hqlString = "from GroupFilm groupfilm";
			Query query = session.createQuery(hqlString);
//			query.setParameter("id", id);
			@SuppressWarnings("unchecked")
			List<GroupFilm> groupFilms  = query.list();
			Iterator<GroupFilm> it = groupFilms.iterator();
			while(it.hasNext()){
				GroupFilm groupFilm = it.next();
//				if(groupFilm.getFilm().getId()== filmId&&groupFilm.getCinema().getId() == cinemaId){
				if(groupFilm.getId()==id)
				{
					groupFilmDetailedInfo.setGroupFilmId(id);
					groupFilmDetailedInfo.setPhotpUrl(groupFilm.getPicUrl());
					groupFilmDetailedInfo.setCinemaAddress(groupFilm.getCinema().getAddress());
					groupFilmDetailedInfo.setCinemaName(groupFilm.getCinema().getCinemaName());
					groupFilmDetailedInfo.setPhoneNum(groupFilm.getCinema().getPhoneNumber());
					groupFilmDetailedInfo.setCommentNum(getCountComments(groupFilm.getId()));
					//groupFilmDetailedInfo.setDeadline(changeDateFormat(groupFilm.getEndDate()));
					groupFilmDetailedInfo.setDirector(groupFilm.getFilm().getDirector());
					groupFilmDetailedInfo.setFilmStar(groupFilm.getFilm().getStar());
					groupFilmDetailedInfo.setPeriod(groupFilm.getFilm().getPeriod());
					groupFilmDetailedInfo.setFilmName(groupFilm.getFilm().getFilmName());
					groupFilmDetailedInfo.setGroupfilmStar(groupFilm.getFilm().getStar());
					groupFilmDetailedInfo.setCommentNum(groupFilm.getUsers().size());
					groupFilmDetailedInfo.setCurrentPrice(groupFilm.getCurrentPrice());
					groupFilmDetailedInfo.setEndDate(groupFilm.getEndDate());
					groupFilmDetailedInfo.setStartDate(groupFilm.getStartDate());
					groupFilmDetailedInfo.setOrderNum(getOderNum(groupFilm.getId()));
					groupFilmDetailedInfo.setDescription(groupFilm.getFilm().getDescription());
//					TODO 	SET TAGS
					groupFilmDetailedInfo.setTags(convertSetToList(groupFilm.getFilm().getTags()));
//					TODO	SET TIME RANGE IN THE DAYLIGHT
					
					
					groupFilmDetailedInfo.setFilmName(groupFilm.getFilm().getFilmName());
				}
//				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return groupFilmDetailedInfo;
	}
	
	/**
	 * get the comment number of the specific group_film
	 * @param groupFilmId
	 * @return
	 */
	private int getCountComments(int groupFilmId){
		int i = 0;
		try{
			session = HibernateUtil.getSession();
			String hqlString = "from Comment";
			Query query = session.createQuery(hqlString);
			@SuppressWarnings("unchecked")
			List<Comment> comments  = query.list();
			Iterator<Comment> it = comments.iterator();
			while(it.hasNext()){
				Comment comment = it.next();
				if(comment.getGroupFilm().getId() == groupFilmId)
					i++;
			}
			}catch(Exception e){
				e.printStackTrace();
		}		
		return i;
	}
	
	private int getOderNum(int groupFilmId){
		int i = 0;
		try{
			session = HibernateUtil.getSession();
			String hqlString = "from Order";
			Query query = session.createQuery(hqlString);
			@SuppressWarnings("unchecked")
			List<Order> orders  = query.list();
			Iterator<Order> it = orders.iterator();
			while(it.hasNext()){
				Order order = it.next();
				if(order.getGroupFilm().getId() == groupFilmId)
					i++;
			}
			}catch(Exception e){
				e.printStackTrace();
		}		
		return i;
	}
	
	
	//团购电影总数
	public int getTotalGroupFilmNum(){
		try{
			session = HibernateUtil.getSession();
			String hql = "select count(*) From GroupFilm";
			Query query = session.createQuery(hql);
			return ((Long)query.uniqueResult()).intValue();		
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		finally{
			HibernateUtil.closeSession();
		}
		
	}
	
	//地区团购电影
	public int getAreaGroupFilmNum(int areaId){
		try{
			session = HibernateUtil.getSession();
			String hql = "select count(*) from GroupFilm groupFilm where groupFilm.area.id = :areaId";
			Query query = session.createQuery(hql);
			query.setParameter("areaId", areaId);
			System.out.println(((Long)query.uniqueResult()).intValue());
			return ((Long)query.uniqueResult()).intValue();		
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	//同一电影数量
	public int getFilmNum(int filmId){
		try{
			session = HibernateUtil.getSession();
			String hql = "select count(*) From GroupFilm groupFilm where groupFilm.film.id=:filmId";
			Query query = session.createQuery(hql);
			query.setParameter("filmId", filmId);
			return ((Long)query.uniqueResult()).intValue();
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	public GroupFilm getGroupFilm(int groupFilmId){
		try{
			session = HibernateUtil.getSession();
			GroupFilm groupFilm = (GroupFilm) session.get(GroupFilm.class, groupFilmId);
			return groupFilm;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	//同一状态电影数目统计
	public int getStatusGroupFilmNum(int type){
		try{
			session = HibernateUtil.getSession();
			String hql = "select count(*) From GroupFilm groupFilm where groupFilm.type=:type";
			Query query = session.createQuery(hql);
			query.setParameter("type", type);
			return ((Long)query.uniqueResult()).intValue();
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	private List<String> convertSetToList(Set<Tag> srcSet){
		List<String> tagStringList = new ArrayList<String>();
		Iterator<Tag> it = srcSet.iterator();
		while(it.hasNext()){
			tagStringList.add(it.next().getTagName().toString());
		}
		return tagStringList;
	}
	
	/**
	 * This method is used to provid the a list of invited Members' information
	 *  which contains id and name 
	 * @author yogiman
	 * @param groupFilmId
	 * @param firstResult
	 * @param maxResult
	 * @return List<InvitedMember>
	 */
	public List<InvitedMember> getInvitedMembers(int groupFilmId,int firstResult,int maxResult){
		
		String hql = "select gf.users from GroupFilm gf where gf.id =";
		Integer i = groupFilmId;
		String str = i.toString();
		hql += str;

		List<InvitedMember> invitedMembers  =  new ArrayList<InvitedMember>();
		List<User> users = HibernateTemplate.executeQuery(hql, firstResult, maxResult);
		Iterator<User> it = users.iterator();
		while(it.hasNext()){
			User user = it.next();
			InvitedMember invitedMember = new InvitedMember();
			invitedMember.setUserId(user.getId());
			invitedMember.setUserName(user.getUserName());
			invitedMembers.add(invitedMember);
		}
		return invitedMembers;
	}
}

