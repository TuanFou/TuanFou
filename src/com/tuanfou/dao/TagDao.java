package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.dto.TagInfo;
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
	
	public boolean update(Tag tag){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(tag);
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
	
	//获得有此标签的电影
	public Set<Film> findFilms(int tagId){
		Session session = null;
		Set<Film> filmSet = new HashSet<Film>();
		try{
			session = HibernateUtil.getSession();
			Tag tag = (Tag)session.get(Tag.class, tagId);
			Set<Film> films = tag.getFilms();
			Iterator<Film> it = films.iterator();
			while(it.hasNext()){
				Film film = it.next();
				filmSet.add(film);
			}
			return filmSet;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
		
	}
	
	//查找标签ID
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
	
	//获得tagInfo，包含tagName，有此标签的films
	@SuppressWarnings("unchecked")
	public List<TagInfo> getTagInfoList(){
		Session session = null;
		List<TagInfo> tagInfoList = new ArrayList<TagInfo>();
		try{
			session = HibernateUtil.getSession();
			String hql = "From Tag";
			Query query = session.createQuery(hql);		
			Iterator<Tag> it = query.list().iterator();
			while(it.hasNext())
			{
				Tag tag = it.next();
				TagInfo tagInfo = new TagInfo();
				tagInfo.setTagId(tag.getId());
				tagInfo.setTagName(tag.getTagName());
				//tagInfo.setFilmNum(tag.getFilmNum());
				tagInfoList.add(tagInfo);
			}
			System.out.println("Success");
			return tagInfoList;			
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
	 * 加载数据库对象
	 * @param tagId
	 * @return
	 */
	public Tag getTag(int tagId){
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Tag tag = (Tag) session.get(Tag.class, tagId);
			return tag;
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
