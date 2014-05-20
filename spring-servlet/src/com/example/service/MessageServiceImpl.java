package com.example.service;

import com.example.dao.MessageDao;

public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao;

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public String getMessage() {
		return messageDao.getMessage();
	}
	
}
