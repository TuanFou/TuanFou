package com.tuanfou.dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.dto.GroupFilmDetailedInfo;
import com.tuanfou.dto.InvitedMember;
import com.tuanfou.dto.RecommendFilm;
import com.tuanfou.pojo.Cinema;
import com.tuanfou.pojo.Comment;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Order;
import com.tuanfou.pojo.Tag;
import com.tuanfou.pojo.User;
import com.tuanfou.utils.HibernateTemplate;
import com.tuanfou.utils.HibernateUtil;
import com.tuanfou.utils.Utils;

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
	
	/*
	 * 锟斤拷取锟脚癸拷锟斤拷影锟斤拷锟斤拷锟斤拷息锟斤拷锟斤拷锟杰伙拷取锟斤拷锟斤拷
	 */
	public List<GroupFilmBriefInfo> getGroupFilmsBriefInfo(int firstResult,int maxResult,String areaName,int type,List<String> tagList){
		List<GroupFilmBriefInfo> list = new ArrayList<GroupFilmBriefInfo>();
		try{
			session = HibernateUtil.getSession();
			Query q = null;
			String hql = null;
			//根据参数设置查询sql语句
			if(type<0){
				hql= "from GroupFilm groupFilm where groupFilm.area.areaName like :areaName";
				q = session.createQuery(hql);
				q.setParameter("areaName", areaName);
			}
			else
			{
				hql= "from GroupFilm groupFilm where groupFilm.area.areaName like :areaName and groupFilm.type like :type";
				q = session.createQuery(hql);
				q.setParameter("areaName", areaName);
				q.setParameter("type", type);
			}
			
			@SuppressWarnings("unchecked")
			List<GroupFilm> groupFilmList = q.list();
			Iterator<GroupFilm> itGroupFilm =groupFilmList.iterator();
			List<GroupFilm> newGroupFilmList = new ArrayList<GroupFilm>();
			while(itGroupFilm.hasNext())
			{
				GroupFilm groupFilm = itGroupFilm.next();
				List<String> tagNameList = Utils.getTagNameList(groupFilm.getFilm().getTags());
				if(tagNameList.containsAll(tagList)){
					newGroupFilmList.add(groupFilm);
				}
			}
			//拼装信息
			Iterator<GroupFilm> it = newGroupFilmList.iterator();
			while(it.hasNext()){
				GroupFilm groupFilm = it.next();
				GroupFilmBriefInfo briefInfo = new GroupFilmBriefInfo();
				briefInfo.setCinemaName(groupFilm.getCinema().getCinemaName());
				briefInfo.setCurrentPrice(groupFilm.getCurrentPrice());
				briefInfo.setOriginalPrice(groupFilm.getOriginalPrice());
				briefInfo.setGroupFilmId(groupFilm.getId());
				//��ȡ��Ӱ����Ϣ
				Film film = groupFilm.getFilm();
				briefInfo.setFilmName(film.getFilmName());
				briefInfo.setHeartNum(groupFilm.getUsers().size());
				briefInfo.setFilmPhotoUrl(groupFilm.getPicUrl());
				//��ȡ��ǩ
				Set<Tag> tags = film.getTags();
				List<String> tagList1 = new ArrayList<String>();
				for(Tag tag:tags){
					tagList1.add(tag.getTagName());
				}
				briefInfo.setTags(tagList1);
				list.add(briefInfo);			
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		if(list.size()<firstResult){
			list.clear();
			return list;
		}else{
			if(list.size()>(maxResult+firstResult)){ 
				List<GroupFilmBriefInfo> resultList =  new ArrayList<GroupFilmBriefInfo>();
				for(int i=firstResult;i<= (firstResult + maxResult -1);i++){
					resultList.add(list.get(i));					
				}
				return resultList;
			}else{
				List<GroupFilmBriefInfo> resultList =  new ArrayList<GroupFilmBriefInfo>();
				for(int i=firstResult;i<= (list.size()-1);i++){
					resultList.add(list.get(i));					
				}
				return resultList;
			}
		}
	}
    /*
     * 获取电影的详细信息
     */
	public GroupFilmDetailedInfo getGroupFilmDetailedInfo(int id){
		GroupFilmDetailedInfo groupFilmDetailedInfo = new GroupFilmDetailedInfo();
		try{
			session = HibernateUtil.getSession();
			String hql = "from GroupFilm groupFilm where id=:id";
			Query  q = session.createQuery(hql);
			q.setParameter("id", id);
			@SuppressWarnings("unchecked")
			List<GroupFilm> groupFilmList = q.list();
			Iterator<GroupFilm> it = groupFilmList.iterator();
			while(it.hasNext()){
				GroupFilm groupFilm = it.next();
				Film film = groupFilm.getFilm();
				
				Iterator<Tag> itTag = film.getTags().iterator();
				while(itTag.hasNext()){
					Tag tag = itTag.next();
					tag.getTagName();
//					System.out.println(tag.getTagName());
				}
				groupFilmDetailedInfo.setGroupFilmId(id);
				groupFilmDetailedInfo.setPhotpUrl(groupFilm.getPicUrl());
				groupFilmDetailedInfo.setCinemaAddress(groupFilm.getCinema().getAddress());
				groupFilmDetailedInfo.setCinemaName(groupFilm.getCinema().getCinemaName());
				groupFilmDetailedInfo.setPhoneNum(groupFilm.getCinema().getPhoneNumber());

				groupFilmDetailedInfo.setFilmName(film.getFilmName());
				groupFilmDetailedInfo.setDirector(film.getDirector());
				groupFilmDetailedInfo.setFilmStar(film.getStar());
				groupFilmDetailedInfo.setPeriod(film.getPeriod());
				groupFilmDetailedInfo.setFilmName(film.getFilmName());
				groupFilmDetailedInfo.setGroupfilmStar(film.getStar());
				groupFilmDetailedInfo.setDescription(film.getDescription());
				 
				groupFilmDetailedInfo.setTags(convertSetToList(film.getTags()));
				//想看人数
				groupFilmDetailedInfo.setPartnerNum(groupFilm.getUsers().size());
				//评论人数
				groupFilmDetailedInfo.setCommentNum(groupFilm.getComments().size());
				groupFilmDetailedInfo.setCurrentPrice(groupFilm.getCurrentPrice());
				//团购开始结束日期
				groupFilmDetailedInfo.setEndDate(groupFilm.getEndDate());
				groupFilmDetailedInfo.setStartDate(groupFilm.getStartDate());
				//预定的人数
				groupFilmDetailedInfo.setOrderNum(getOderNum(groupFilm.getId()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return groupFilmDetailedInfo;
	}
	
//	public GroupFilmDetailedInfo getGroupFilmDetailedInfo(int id){
//		GroupFilmDetailedInfo groupFilmDetailedInfo=new GroupFilmDetailedInfo();
//		try{
//			session = HibernateUtil.getSession();
//			String hqlString = "from GroupFilm groupfilm";
//			Query query = session.createQuery(hqlString);
//			@SuppressWarnings("unchecked")
//			List<GroupFilm> groupFilms  = query.list();
//			Iterator<GroupFilm> it = groupFilms.iterator();
//			while(it.hasNext()){
//				GroupFilm groupFilm = it.next();
//				if(groupFilm.getId()==id)
//				{
//					groupFilmDetailedInfo.setGroupFilmId(id);
//					groupFilmDetailedInfo.setPhotpUrl(groupFilm.getPicUrl());
//					groupFilmDetailedInfo.setCinemaAddress(groupFilm.getCinema().getAddress());
//					groupFilmDetailedInfo.setCinemaName(groupFilm.getCinema().getCinemaName());
//					groupFilmDetailedInfo.setPhoneNum(groupFilm.getCinema().getPhoneNumber());
//					groupFilmDetailedInfo.setCommentNum(getCountComments(groupFilm.getId()));
//					
//					//获取电影信息
//					Film film =  groupFilm.getFilm();
//					if(!Hibernate.isInitialized(film)){
//						Hibernate.initialize(film);
//					}
//					groupFilmDetailedInfo.setFilmName(film.getFilmName());
//					groupFilmDetailedInfo.setDirector(film.getDirector());
//					groupFilmDetailedInfo.setFilmStar(film.getStar());
//					groupFilmDetailedInfo.setPeriod(film.getPeriod());
//					groupFilmDetailedInfo.setFilmName(film.getFilmName());
//					groupFilmDetailedInfo.setGroupfilmStar(film.getStar());
//					groupFilmDetailedInfo.setDescription(film.getDescription());
//					groupFilmDetailedInfo.setTags(convertSetToList(film.getTags()));
//					//想看人数
//					groupFilmDetailedInfo.setCommentNum(groupFilm.getUsers().size());
//					groupFilmDetailedInfo.setCurrentPrice(groupFilm.getCurrentPrice());
//					//团购开始结束日期
//					groupFilmDetailedInfo.setEndDate(groupFilm.getEndDate());
//					groupFilmDetailedInfo.setStartDate(groupFilm.getStartDate());
//					//预定的人数
//					groupFilmDetailedInfo.setOrderNum(getOderNum(groupFilm.getId()));
//				}
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			HibernateUtil.closeSession();
//		}
//		return groupFilmDetailedInfo;
//	}
	
	/**
	 * get the comment number of the specific group_film
	 * @param groupFilmId
	 * @return
	 */
	@SuppressWarnings("unused")
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
		}finally{
			HibernateUtil.closeSession();
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
		}finally{
			HibernateUtil.closeSession();
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
	//取出团购电影对象
	public GroupFilm getGroupFilm(int groupFilmId){
		try{
			session = HibernateUtil.getSession();
			GroupFilm groupFilm = (GroupFilm) session.get(GroupFilm.class, groupFilmId);
			System.out.println("groupFilmId:"+groupFilm.getId());
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
	
	// TODO CAHNGE THE PUBLIC TO PRIVATE
	private List<String> convertSetToList(Set<Tag> srcSet){
		List<String> tagStringList = new ArrayList<String>();
		Iterator<Tag> it = srcSet.iterator();
		while(it.hasNext()){
			tagStringList.add(it.next().getTagName().toString());
		}
		return tagStringList;
		
	}
	
	//获得所有正在上映和即将上映的电影
	@SuppressWarnings("unchecked")
	public List<RecommendFilm> getNoffFilm(){
		List<RecommendFilm> films = new ArrayList<RecommendFilm>();
		try{
			session = HibernateUtil.getSession();
			String hql = "From GroupFilm groupFilm where groupFilm.type=0 or groupFilm.type=1";
			Query query = session.createQuery(hql);
			List<GroupFilm> NoffFilmList = query.list();
			Iterator<GroupFilm> it = NoffFilmList.iterator();
			while(it.hasNext()){
				GroupFilm groupFilm = it.next();
				RecommendFilm aRfilm = new RecommendFilm();
				aRfilm.setPicUrl(groupFilm.getPicUrl());
				Film film = groupFilm.getFilm();
				aRfilm.setFilmName(film.getFilmName());
				Cinema  cinema = groupFilm.getCinema();
				aRfilm.setCinemaName(cinema.getCinemaName());
				aRfilm.setGroupFilmId(groupFilm.getId());
				aRfilm.setUserNum(groupFilm.getUsers().size());
				films.add(aRfilm);		
			}
			return films;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	//获得一个团购电影想看人数
	public int getWantedUserNum(int groupFilmId){
		try{
			session = HibernateUtil.getSession();
			GroupFilm groupFilm = (GroupFilm) session.get(GroupFilm.class, groupFilmId);
			return groupFilm.getUsers().size();
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	//团购电影价格
	public float getPrice(int groupFilmId){
		try{
			session = HibernateUtil.getSession();
			GroupFilm groupFilm = (GroupFilm) session.get(GroupFilm.class, groupFilmId);
			return groupFilm.getCurrentPrice();
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	/**
	+	 * This method is used to provid the a list of invited Members' information
	+	 *  which contains id and name 
	+	 * @author yogiman
	+	 * @param groupFilmId
	+	 * @param firstResult
	+	 * @param maxResult
	+	 * @return List<InvitedMember>
	+	 */
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
	/*
	 * 添加想看的人
	 */
	public boolean addHartUser(int  userId, int groupFilmId){
		 try{
			 session = HibernateUtil.getSession();
			 GroupFilm groupFilm = (GroupFilm) session.get(GroupFilm.class, groupFilmId);
			 session.beginTransaction();
			 User user = new User();
			 user.setId(userId);
			 groupFilm.getUsers().add(user);
			 session.update(groupFilm);
			 session.getTransaction().commit();
		 }catch(Exception e){
			 e.printStackTrace();
			 return false;
		 }
		 return true;
	}
}


