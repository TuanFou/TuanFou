package com.tuanfou.service;

import java.sql.Date;
import java.util.List;

import com.tuanfou.dao.AccountDao;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dao.OrderDao;
import com.tuanfou.dao.UserDao;
import com.tuanfou.dto.OrderInfo;
import com.tuanfou.pojo.Account;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Order;
import com.tuanfou.pojo.User;

public class OrderService {

	/**
	 * 下订单
	 * 返回值为Boolean，标识下订单是否成功
	 */
	public int orderFilm(int groupFilmId,int userId,int amount){
		OrderDao orderDao = new OrderDao();
		UserDao userDao = new UserDao();
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		User user = userDao.getUser(userId);
		GroupFilm groupFilm = groupFilmDao.getGroupFilm(groupFilmId); 
		Order order = new Order();
		order.setStatus(1);  //设置订单状态为未支付
		order.setUser(user);
		order.setGroupFilm(groupFilm);
		order.setAmount(amount);
		order.setExpiredTime(groupFilm.getEndDate());
		
		Date createTime = new Date(new java.util.Date().getTime());
		order.setCreateTime(createTime);
		int res = -1;
		if(orderDao.addOrder(order)){
			res = order.getId();
		}
		return res;
	}
	
	/**
	 * 支付订单
	 * 返回值为Boolean，标识支付订单是否成功
	 */
	public boolean pay(int orderId){
		OrderDao orderDao = new OrderDao();
		AccountDao accountDao = new AccountDao();
		UserDao userDao = new UserDao();
		
		Order order = orderDao.getOrder(orderId);
		User user = orderDao.getUser(orderId);
		GroupFilm groupFilm = orderDao.getGroupFilm(orderId);
		Account account = userDao.getAccount(user.getId());

		float filmPrice = groupFilm.getCurrentPrice();
		float balance = account.getBalance();
		if(balance > filmPrice*order.getAmount())
		{
			account.setBalance(balance-filmPrice*order.getAmount());
			accountDao.update(account);
			order.setStatus(2);
			orderDao.update(order);
			return true;
		}
		else
			return false;
	}
	/*
	 * 功能:通过用户id获取用户的所有订单
	 */
	public List<OrderInfo> getUserOrdersById(int id){
		OrderDao orderDao = new OrderDao();
		List<OrderInfo> list = orderDao.getOrdersByUserId(id);
		return list;
	}
}

