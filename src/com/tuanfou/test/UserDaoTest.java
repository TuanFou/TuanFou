package com.tuanfou.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.tuanfou.dao.GroupFilmDao;
import com.tuanfou.dao.UserDao;
import com.tuanfou.dto.MyHeartGroupFilmInfo;
import com.tuanfou.pojo.Account;
import com.tuanfou.pojo.City;
import com.tuanfou.pojo.GroupFilm;
import com.tuanfou.pojo.User;
import com.tuanfou.utils.GsonTestTemplate;

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
		getHeartGroupFilmsTest();
	}
	
	/**
	 * test getHeartGroupFilmsTest()
	 * @author yogiman
	 */
	public static void getHeartGroupFilmsTest(){
		UserDao userDao = new UserDao();
		//GsonTestTemplate.testListToString(userDao.getHeartGroupFilms(307016211));
		List<MyHeartGroupFilmInfo> myHeartGroupFilmInfoList = userDao.getHeartGroupFilms(307016211);
		Gson gson =new Gson();
		String string = gson.toJson(myHeartGroupFilmInfoList);
		
//		Iterator<GroupFilm> groupFilmIterator = groupFlimList.iterator();
//		while(groupFilmIterator.hasNext()){
//			GroupFilm groupFilm = groupFilmIterator.next();
//			System.out.println(groupFilm.getId());
//		System.out.print(groupFlimList.get(0).getId());
		System.out.println(string);
	}
	
	/**
	 * test List.addAll()
	 * list.addAll(Set)
	 * @author yogiman
	 */
	public static void testListAddAll(){
		List<Integer> integerList = new ArrayList<Integer>();
		Set<Integer> integerSet = new HashSet<Integer>();
		integerSet.add(1);
		integerSet.add(23);
		integerList.addAll(integerSet);
		Iterator<Integer> intIterator = integerList.iterator();
		while(intIterator.hasNext()){
			System.out.println(intIterator.next());
		}
		
	}

}
