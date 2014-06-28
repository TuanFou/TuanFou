package com.tuanfou.test;

//import java.sql.Date;
//import java.util.Calendar;

import java.util.Iterator;
import java.util.List;

import com.tuanfou.dao.MessageDao;
import com.tuanfou.pojo.Message;

public class MessageDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MessageDao messageDao = new MessageDao();
		List<Message> list = messageDao.findReceiveMsg(1, 1);
		
		//Date date = new Date(new java.util.Date().getTime());
			
		for(Iterator<Message> it = list.iterator();it.hasNext();){
			Message message = it.next();
			System.out.print("Message_content:"+message.getContent());
			System.out.println("	Message_time:"+message.getTime());
		}
	}

}
