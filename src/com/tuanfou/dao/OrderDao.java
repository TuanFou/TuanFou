package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Order;
import com.tuanfou.pojo.User;
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
	
	//找到订单的User
	public User getUser(int orderId){
		try{
			session = HibernateUtil.getSession();
			Order order = (Order) session.get(Order.class, orderId);
			return order.getUser();
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	//找到订单的团购电影
	public GroupFilm getGroupFilm(int orderId){
		try{
			session = HibernateUtil.getSession();
			Order order = (Order) session.get(Order.class, orderId);
			GroupFilm groupFilm = new GroupFilm();
			groupFilm.setCurrentPrice(order.getGroupFilm().getCurrentPrice());
			return groupFilm;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	public Order getOrder(int orderId){
		try{
			session = HibernateUtil.getSession();
			Order order = (Order) session.get(Order.class, orderId);
			return order;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
	
	public boolean update(Order order){
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(order);
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			HibernateUtil.closeSession();
		}
	}
}