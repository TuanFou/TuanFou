package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.pojo.Complaint;
import com.tuanfou.utils.HibernateUtil;

public class ComplaintDao {
	Session session = null;
	
	/*
	 * 添加一个投诉
	 */
	public boolean addComplaintr(Complaint complaint){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(complaint);
			session.getTransaction().commit();//提交事物
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事物
			System.out.println("添加投诉失败");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
	/*
	 * 获取订单列表
	 */
	@SuppressWarnings("unchecked")
	public List<Complaint> getComplaintList(){
		List<Complaint> complaintList = new ArrayList<Complaint>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from Complaint complaint";
			Query q = session.createQuery(hql);
			complaintList = q.list();
		}catch(Exception e){
			System.out.println("查询失败");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return complaintList;	
	}
}