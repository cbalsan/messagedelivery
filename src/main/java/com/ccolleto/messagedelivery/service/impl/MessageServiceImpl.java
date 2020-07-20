package com.ccolleto.messagedelivery.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccolleto.messagedelivery.dao.MessageDAO;
import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.dao.model.SearchCriteria;
import com.ccolleto.messagedelivery.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO dao;

	@Override
	public void add(Message message) {
		dao.add(message);
	}

	@Override
	public List<Message> getMessagesToBeDelivered(LocalDateTime currentTime) {
		return dao.findAll(new SearchCriteria(false, currentTime));
	}

	@Override
	public void markMessagesAsDelivered(Message message, LocalDateTime deliveredAt) {
		message.setDelivered(true);
		message.setDeliveredAt(deliveredAt);
		dao.update(message);
	}
}
