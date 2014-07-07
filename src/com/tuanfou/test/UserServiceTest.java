package com.tuanfou.test;

import java.util.Iterator;
import java.util.Set;

import com.tuanfou.dto.MyCommentInfo;
import com.tuanfou.service.UserService;

public class UserServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService us = new UserService();
		Set<MyCommentInfo> cs = us.getMyComments(319010001);
		Iterator<MyCommentInfo> csIterator = cs.iterator();
		while(csIterator.hasNext()) {
			System.out.println(csIterator.next().getTime());
		}
	}

}
