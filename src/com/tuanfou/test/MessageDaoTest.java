package com.tuanfou.test;

import java.sql.Date;
//import java.util.Calendar;

import com.tuanfou.dao.MessageDao;
import com.tuanfou.pojo.Message;

public class MessageDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setContent("Õ∂Àﬂ–≈œ¢");
		message.setReceiverId(1);
		message.setSenderId(1);
		Date time= new java.sql.Date(new java.util.Date().getTime());
		message.setTime(time);
		message.setType(1);
		
		MessageDao messageDao = new MessageDao();
		messageDao.add(message);
		
	}

}
