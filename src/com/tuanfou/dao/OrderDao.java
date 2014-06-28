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
	 * 添加一个订单
	 */
	public boolean addOrder(Order order){
		boolean res = false;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();//开始事物
			session.save(order);
			session.getTransaction().commit();//提交事物
			res = true;
		}catch(Exception e){
			session.getTransaction().rollback();//回滚事物
			System.out.println("添加订单失败");
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
	public List<Order> getOrderList(){
		List<Order> orderList = new ArrayList<Order>();
		try{
			session = HibernateUtil.getSession();
			String hql = "from Order order";
			Query q = session.createQuery(hql);
			orderList = q.list();
		}catch(Exception e){
			System.out.println("查询失败");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return orderList;	
	}
}