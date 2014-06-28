package com.tuanfou.test;

import com.tuanfou.dao.UserDao;
import com.tuanfou.pojo.Account;
import com.tuanfou.pojo.City;
import com.tuanfou.pojo.User;

public class UserDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		User user = new User();
//		City city = new City();
//		Account account = new Account();
//		account.setBalance(10);
//		city.setId(2);
//		user.setAccount(account);
//		user.setCity(city);
//		user.setEmail("kdf@163.com");
//		user.setDescription("hello");
//		user.setPassword("123");
//		user.setUserName("kongdefei5000");
//		user.setPhotoUrl("kdf.jpg");
//		UserDao userDao = new UserDao();
//		userDao.addUser(user);
//		System.out.println(user.getCity().getId());
		UserDao userDao = new UserDao();
		System.out.println(userDao.getUserComments(1));
	}

}
