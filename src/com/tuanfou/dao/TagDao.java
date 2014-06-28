package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.Tag;
import com.tuanfou.utils.HibernateUtil;

public class TagDao {
	
	public boolean add(Tag tag){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(tag);
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	public Set<Film> findFilms(int tagId){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Tag tag = (Tag)session.get(Tag.class, tagId);
			Set<Film> films = tag.getFilms();
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
	@SuppressWarnings("unchecked")
	public int findId(String tagName){
		Session session = null;
		List<Tag> list = new ArrayList<Tag>();
		try{
			session = HibernateUtil.getSession();
			String hql = "From Tag tag where tag.tagName=:name";
			Query query = session.createQuery(hql);
			query.setParameter("name", tagName);
			list = query.list();
			Iterator<Tag> it = list.iterator();
			if(it.hasNext())
			{
				Tag tag = it.next();
				return tag.getId();
			}
			else
				return -1;
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		finally{
			HibernateUtil.closeSession();
		}
		
	}
}
