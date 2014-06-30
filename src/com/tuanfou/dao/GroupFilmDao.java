package com.tuanfou.dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.dto.GroupFilmBriefInfo;
import com.tuanfou.pojo.Film;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Tag;
import com.tuanfou.utils.HibernateTemplate;
import com.tuanfou.utils.HibernateUtil;

public class GroupFilmDao {
	private Session session = null;
	/*
	 * ����Ź���Ӱ
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
	 * ��ȡ�Ź���Ϣ,ֻ���г�
	 */
	public List<GroupFilm> getGroupFilms(int firstResult,int maxResult){
		String hql = "from GroupFilm groupFilm";
		List<GroupFilm> groupFilms  =  HibernateTemplate.executeQuery(hql, firstResult, maxResult);
		return groupFilms;	
	}
	
	/*
	 * ��ȡ�Ź���Ӱ������Ϣ�����ܻ�ȡ����
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
				//��ȡ��Ӱ����Ϣ
				Film film = groupFilm.getFilm();
				briefInfo.setFilmName(film.getFilmName());
				briefInfo.setHeartNum(groupFilm.getUsers().size());
				briefInfo.setFilmPhotoUrl(groupFilm.getPicUrl());
				//��ȡ��ǩ
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
}
