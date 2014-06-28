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
	 * ���һ��Ͷ��
	 */
	public boolean addComplaintr(Complaint complaint){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(complaint);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("���Ͷ��ʧ��");
			e.printStackTrace();
			res = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return res;
	}
	/*
	 * ��ȡ�����б�
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
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return complaintList;	
	}
}