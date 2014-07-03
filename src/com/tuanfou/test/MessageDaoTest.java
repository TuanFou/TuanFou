package com.tuanfou.test;

//import java.sql.Date;
//import java.util.Calendar;

import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.tuanfou.dao.MessageDao;
import com.tuanfou.pojo.Message;
import com.tuanfou.utils.GsonTestTemplate;

public class MessageDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		MessageDao messageDao = new MessageDao();
//		List<Message> list = messageDao.findReceiveMsg(1, 1);
//		
//		//Date date = new Date(new java.util.Date().getTime());
//			
//		for(Iterator<Message> it = list.iterator();it.hasNext();){
//			Message message = it.next();
//			System.out.print("Message_content:"+message.getContent());
//			System.out.println("	Message_time:"+message.getTime());
//		}
//		getReceivedMessageTest();
		getReceivedMessageTest();
	}
	
	
	/**
	 * @author yogiman
	 */
	public static void getReceivedMessageTest(){
		MessageDao messageDao = new MessageDao();
		List<Message> messages =  messageDao.getReceivedMessage(2, 0, 2);
		GsonTestTemplate.testListToString(messages);
	}

	/**
	 * @author yogiman
	 */
	public static void getSentMessageTest(){
		MessageDao messageDao = new MessageDao();
		List<Message> messages =  messageDao.getSentMessages(10, 0, 2);
		Gson gson = new Gson();
		String string = gson.toJson(messages);
		System.out.println(string);
	}

}
