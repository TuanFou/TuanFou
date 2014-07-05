package com.tuanfou.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dao.UserDao;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.pojo.Account;
import com.tuanfou.pojo.City;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.User;
import com.tuanfou.service.UserService;
import com.tuanfou.utils.GsonTestTemplate;
import com.tuanfou.utils.HibernateUtil;

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
////		System.out.println(user.getCity().getId());
//		UserDao userDao = new UserDao();
//		System.out.println(userDao.getUserComments(1));
//		System.out.println(Integer.MAX_VALUE);
		//getHeartGroupFilmsTest();
//		UserService userService = new UserService();
//		User user = userService.getUserInfo(304010333);
//		
//		System.out.println(user.getAccount().getBalance());
//		UserDao userDao = new UserDao();
//		
//		List<MyHeartGroupFilmInfo> list = userDao.getHeartGroupFilms(302010010);
//		Gson gson = new Gson();
//		String str = gson.toJson(list);
//		System.out.println(str)
		
		/**
		 * 用户登陆测试开始
		 */
		String matching = "ERROR";
		String username = "testAddUser";
		String password = "5555566666";
		try{

			Session session = HibernateUtil.getSession();
			String hql = "from User user where user.userName=:username and user.password=:password";
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<User> userList = query.list();
			Iterator<User> itUser =userList.iterator();
			if(itUser.hasNext())
				{			
					matching = "SUCCESS";
				}
		}catch(Exception e){
			e.printStackTrace();
			matching = "ERROR";
		}finally{
			HibernateUtil.closeSession();
		}
		System.out.println(matching);
		/**
		 * 用户登陆测试到此为止
		 */
		

		/**
		 * 新用户注册测试开始
		 *//*
		City aCity = new City();
		User aUser = new User();
		aCity.setId(31901);
		aUser.setUserName("testAddUser");
		aUser.setPassword("5555566666");
		aUser.setCity(aCity);
		UserService us = new UserService();
		List<User> userList = us.getUserList();
		Iterator<User> itUser =userList.iterator();
		boolean res = true;
		while(itUser.hasNext())
		{			
			if(itUser.next().getUserName()=="testAddUser"){
				res = false;
				break;
			}
		}
		//from test as t where t.id=(select max(s.id) from test s)
		if(res) {
		    
			Account account = new Account();
			account.setBalance(0);
			us.addAccount(account);
			Session session = HibernateUtil.getSession();
			@SuppressWarnings("unchecked")
			List<Account> accountList = session.createQuery("from Account account where account.id=(select max(a.id) from Account a)").list();
			Iterator<Account> itAccount =accountList.iterator();
			while(itAccount.hasNext())
			{	
				//System.out.println(itAccount.next().getId());
				aUser.setAccount(itAccount.next());
			}
			us.addUser(aUser);  
		}
	}
	/**
	 * 新用户注册测试到此为止
	 */
	
	/**
	 * test getHeartGroupFilmsTest()
	 * @author yogiman
	 */
//	public static void getHeartGroupFilmsTest(){
//		UserDao userDao = new UserDao();
//		//GsonTestTemplate.testListToString(userDao.getHeartGroupFilms(307016211));
//		List<MyHeartGroupFilmInfo> myHeartGroupFilmInfoList = userDao.getHeartGroupFilms(307016211);
//		Gson gson =new Gson();
//		String string = gson.toJson(myHeartGroupFilmInfoList);
//		
////		Iterator<GroupFilm> groupFilmIterator = groupFlimList.iterator();
////		while(groupFilmIterator.hasNext()){
////			GroupFilm groupFilm = groupFilmIterator.next();
////			System.out.println(groupFilm.getId());
////		System.out.print(groupFlimList.get(0).getId());
//		System.out.println(string);
//	}
	
	/**
	 * test List.addAll()
	 * list.addAll(Set)
	 * @author yogiman
	 */
//	public static void testListAddAll(){
//		List<Integer> integerList = new ArrayList<Integer>();
//		Set<Integer> integerSet = new HashSet<Integer>();
//		integerSet.add(1);
//		integerSet.add(23);
//		integerList.addAll(integerSet);
//		Iterator<Integer> intIterator = integerList.iterator();
//		while(intIterator.hasNext()){
//			System.out.println(intIterator.next());
//		}
		
//	}

	}}
