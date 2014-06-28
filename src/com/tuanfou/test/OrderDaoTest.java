package com.tuanfou.test;

import com.tuanfou.dao.OrderDao;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.User;
import com.tuanfou.pojo.Order;
public class OrderDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		GroupFilm groupFilm = new GroupFilm();
		Order order = new Order();
		//account.setBalance(10);
		//city.setCityName("wuhan");
		//user.setAccount(account);
		//user.setCity(city);
		//user.setEmail("kdf@163.com");
		//user.setDescription("hello");
		//user.setPassword("123");
		user.setUserName("hcz92");
		groupFilm.setId(1);
		order.setGroupFilm(groupFilm);
		user.setId(1);
		order.setUser(user);
		order.setCreateTime(null);
		order.setExpiredTime(null);
		order.setStatus(0);
		OrderDao OrderDao = new OrderDao();
		OrderDao.addOrder(order);
		System.out.println(order.getGroupFilm().getOriginalPrice());
	}

}