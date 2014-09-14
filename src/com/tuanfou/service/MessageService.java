package com.tuanfou.service;

import java.util.Date;
import java.util.List;

import com.tuanfou.dao.MessageDao;
import com.tuanfou.dao.UserDao;
import com.tuanfou.dto.MessageInfo;
import com.tuanfou.pojo.Message;

public class MessageService {
	/*
	 * 添加一条消息
	 */
	public boolean addMessage(int senderId,int receiverId,String content,int type){
		Message message = new Message();
		message.setSenderId(senderId);
		message.setReceiverId(receiverId);
		message.setType(type);
		message.setContent(content);
		message.setTime(new Date(System.currentTimeMillis()));
		MessageDao messageDao = new MessageDao();
		if(messageDao.add(message))
			return true;
		else
			return false;	
	}
	/*
	 * 获取指定用户的消息
	 */
	public  List<MessageInfo> getUserMessages(int userId,int type){
		MessageDao messageDao = new MessageDao();
		//目前只获取用户之间的消息
		UserDao userDao = new UserDao();
		
		List<MessageInfo> messageList = messageDao.getMessagesByUserId(userId, type);
		if(messageList!=null){
			for(MessageInfo msgInfo :messageList){
				String senderName = userDao.getUser(msgInfo.getSenderId()).getUserName();
				String receiverName = userDao.getUser(msgInfo.getReceiverId()).getUserName();
				msgInfo.setSenderName(senderName);
				msgInfo.setReceiverName(receiverName);
				msgInfo.setPhotoUrl("./imgs/girl2.jpg");
			}
		}
		return messageList;
	}
	
}
