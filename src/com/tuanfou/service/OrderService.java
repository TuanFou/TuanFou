package com.tuanfou.service;

import java.sql.Date;

import com.tuanfou.dao.AccountDao;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dao.OrderDao;
import com.tuanfou.dao.UserDao;
import com.tuanfou.pojo.Account;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.Order;
import com.tuanfou.pojo.User;

public class OrderService {

	/**
	 * 下订单
	 * 返回值为Boolean，标识下订单是否成功
	 */
	public boolean orderFilm(int groupFilmId,int userId,Date expiredTime){
		OrderDao orderDao = new OrderDao();
		UserDao userDao = new UserDao();
		GroupFilmDao groupFilmDao = new GroupFilmDao();
		User user = userDao.getUser(userId);
		//Film film = filmDao.getFilm(groupFilmId);
		GroupFilm groupFilm = groupFilmDao.getGroupFilm(groupFilmId); 
		Order order = new Order();
		order.setExpiredTime(expiredTime);
		order.setStatus(1);  //设置订单状态为未支付
		order.setUser(user);
		order.setGroupFilm(groupFilm);
		
		Date createTime = new Date(new java.util.Date().getTime());
		order.setCreateTime(createTime);
		return orderDao.addOrder(order);
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
		if(balance > filmPrice)
		{
			account.setBalance(balance-filmPrice);
			accountDao.update(account);
			order.setStatus(2);
			orderDao.update(order);
			return true;
		}
		else
			return false;
	}
		
}

