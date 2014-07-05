package com.tuanfou.dao;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.Tag;
import com.tuanfou.utils.HibernateUtil;

public class FilmDao {
	Session session = null;
	
	/**
	 * 添加一个电�
	 * @param film
	 * @return
	 */
	public boolean addFilm(Film film){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(film);
			session.getTransaction().commit();//提交事务
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事务
			System.out.println("添加电影失败");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}

	
	//电影总数
	public int getTotalFilmsNum(){
		try{
			session = HibernateUtil.getSession();
			String hql = "Select count(*) from Film";
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
	
	//获得数据库对象
	public Film getFilm(int filmId){
		try{
			session = HibernateUtil.getSession();
			Film film = (Film) session.get(Film.class, filmId);
			return film;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	//获得已有电影列表
	@SuppressWarnings("unchecked")
	public List<Film> getFilmList(){
		List<Film> filmList = new ArrayList<Film>();
		try{
			session = HibernateUtil.getSession();
			String hql = "From Film";
			Query query = session.createQuery(hql);
			Iterator<Film> it = query.list().iterator();
			while(it.hasNext()){
				Film afilm = it.next();
				Film film = new Film();
				film.setId(afilm.getId());
				film.setFilmName(afilm.getFilmName());
				filmList.add(film);				
			}
			return filmList;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	public Set<Tag> getTags(int filmId){
		Set<Tag> tags = new HashSet<Tag>();
		try{
			session = HibernateUtil.getSession();
			Film film = (Film) session.get(Film.class, filmId);
			Iterator<Tag> it = film.getTags().iterator();
			while(it.hasNext()){
				Tag tag = it.next();
				tags.add(tag);
			}
			return tags;
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
