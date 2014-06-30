package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.pojo.Order;
import com.tuanfou.utils.HibernateUtil;

public class OrderDao {
	Session session = null;
	
	/*
	 * ���һ������
	 */
	public boolean addOrder(Order order){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//��ʼ����
			session.save(order);
			session.getTransaction().commit();//�ύ����
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//�ع�����
			System.out.println("��Ӷ���ʧ��");
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
	public List<Order> getOrderList(){
		List<Order> orderList = new ArrayList<Order>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from Order order";
			Query q = session.createQuery(hql);
			orderList = q.list();
		}catch(Exception e){
			System.out.println("��ѯʧ��");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return orderList;	
	}
	
}