package com.tuanfou.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tuanfou.dto.OrderInfo;
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
	//实例化加载数据库对象
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
	//更新订单信息
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
	/*
	 * 根据用户id获取用户的所有订单
	 */
	 public List<OrderInfo> getOrdersByUserId(int id){
		 List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
		 String hql = "from Order order where order.user.id="+id;
		 try{
			 session = HibernateUtil.getSession();
			 Query q = session.createQuery(hql);
			 List<Order> list = q.list();
			 Iterator<Order> it = list.iterator();
			 while(it.hasNext()){
				 Order order = it.next();
				 OrderInfo orderInfo = new OrderInfo();
				 orderInfo.setAmount(order.getAmount());
				 orderInfo.setCurretPrice(order.getGroupFilm().getCurrentPrice());
				 orderInfo.setFilmName(order.getGroupFilm().getFilm().getFilmName());
				 orderInfo.setOrderId(order.getId());
				 orderInfo.setOrderTime(order.getCreateTime());
				 orderInfo.setOriginalPrice(order.getGroupFilm().getOriginalPrice());
				 switch(order.getStatus()){
				 case 0:
					 orderInfo.setStatus("失效");
					 break;
				 case 1:
					 orderInfo.setStatus("未支付");
					 break;
				 case 2:
					 orderInfo.setStatus("已支付");
					 break;
				 }
				 orderInfo.setTotalPrice(orderInfo.getCurretPrice()*orderInfo.getAmount());
				 orderInfoList.add(orderInfo);
			 }
			 return orderInfoList;
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 HibernateUtil.closeSession();
		 }
		 return orderInfoList;
	 }
}