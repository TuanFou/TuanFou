package com.tuanfou.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import com.tuanfou.pojo.Comment;
import com.tuanfou.utils.HibernateTemplate;
import com.tuanfou.utils.HibernateUtil;

public class CommentDao {
	/*
	 * 添加一个评论
	 */
	private  Session session = null;
	private int POSITIVE_INFINITY;
	public boolean addComment(Comment comment){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(comment);
			session.getTransaction().commit();//提交事物
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事物
			System.out.println("添加评论失败");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
	/*
	 * 由团购电影id获取用户评论
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
			System.out.println("查询失败");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return commentList;	
	}
	/*
	 * 根据团购电影id获取评价的平均值
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
}
