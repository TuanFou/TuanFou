package com.tuanfou.dao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import com.tuanfou.dto.CommentInfo;
import com.tuanfou.pojo.Comment;
import com.tuanfou.pojo.User;
import com.tuanfou.utils.ComparatorCommentInfo;
import com.tuanfou.utils.HibernateUtil;

public class CommentDao {
	/*
	 * ���һ������
	 */
	private  Session session = null;
	public boolean addComment(Comment comment){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(comment);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("�������ʧ��");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
	/*
	 * ���Ź���Ӱid��ȡ�û�����
	 */

	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsByGroupFilmId(int i){
		List<Comment> commentList = new ArrayList<Comment>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from Comment comment where comment.groupFilm.id=:id";
			Query q = session.createQuery(hql);
			q.setParameter("id", i);
			commentList = q.list();
		}catch(Exception e){
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return commentList;	
	}
	/*
	 * ����Ź���Ӱid��ȡ���۵�ƽ��ֵ
	 */
	public float getStarByGroupFilmId(int id){
		float total = 0;
		String hql = "select avg(comment.star) from Comment comment where comment.groupFilm.id ="+ id;
		@SuppressWarnings("unchecked")
		List<Object> avgStar =   HibernateUtil.getSession().createQuery(hql).list();
		for(Object listTemp : avgStar) { 
			if(listTemp == null){
				total = 0;
			}else{
				total = Float.parseFloat(listTemp.toString());
			}
         }
		return total;
	}
	
	/*
	 * 获得对一个团购电影的评价列表
	 */
	@SuppressWarnings("unchecked")
	public List<CommentInfo> getCommentInfo(int groupFilmId){
		List<CommentInfo> commentList = new ArrayList<CommentInfo>();
		try{
			session = HibernateUtil.getSession();
			String hql = "From Comment comment where comment.groupFilm.id=:groupFilmId";
			Query query = session.createQuery(hql);
			query.setParameter("groupFilmId", groupFilmId);
			Iterator<Comment> it = query.list().iterator();
			while(it.hasNext()){
				Comment comment = it.next();
				CommentInfo commentInfo = new CommentInfo();
				User user = comment.getUser();
				commentInfo.setUserId(user.getId());
				commentInfo.setUserName(user.getUserName());
				commentInfo.setGroupFilmId(comment.getGroupFilm().getId());
				commentInfo.setDate(comment.getCreateTime());
				commentInfo.setContent(comment.getContent());
				commentInfo.setStar(comment.getStar());
				commentList.add(commentInfo);
			}
			commentList = sortComment(commentList);
			return commentList;
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
	 * This method makes the comment list in a decrease order
	 * @param commentList
	 * @return
	 */
	private List<CommentInfo> sortComment(List<CommentInfo> commentList) {
		ComparatorCommentInfo comparator = new ComparatorCommentInfo();
		Collections.sort(commentList, comparator);
		return commentList;
		
	}
}
