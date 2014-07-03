package com.tuanfou.test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.tuanfou.dao.OrderDao;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.User;
import com.tuanfou.pojo.Order;
import com.tuanfou.service.OrderService;
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
		/*user.setUserName("hcz92");
		groupFilm.setId(1);
		order.setGroupFilm(groupFilm);
		user.setId(1);
		order.setUser(user);
		order.setCreateTime(null);
		order.setExpiredTime(null);
		order.setStatus(0);
		OrderDao OrderDao = new OrderDao();
		OrderDao.addOrder(order);
		System.out.println(order.getGroupFilm().getOriginalPrice());*/
		OrderService orderService = new OrderService();
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try{
			java.util.Date date = dateFormat.parse("2014-8-1");
			//java.util.Date date = new java.util.Date();
			Date expiredTime = new Date(date.getTime());
			if(orderService.orderFilm(1, 1, expiredTime))
				System.out.println("下订单成功");
			else
				System.out.println("下订单失败");
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		if(orderService.pay(3))
			System.out.println("支付成功");
			
	}

}