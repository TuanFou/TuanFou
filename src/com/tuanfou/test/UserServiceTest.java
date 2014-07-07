package com.tuanfou.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


import com.google.gson.Gson;
import com.tuanfou.dto.MessageInfo;
import com.tuanfou.dto.MyCommentInfo;
import com.tuanfou.service.UserService;

public class UserServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService us = new UserService();
		List<MessageInfo> cs = (List<MessageInfo>) us.getMyMessages(319010023);

		Gson gson = new Gson();
		String result = gson.toJson(cs);
		System.out.println(result);
	}

}
