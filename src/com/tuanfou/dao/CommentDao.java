package com.tuanfou.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import com.tuanfou.pojo.Comment;
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
}
