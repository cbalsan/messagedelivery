package com.ccolleto.messagedelivery.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.delivery.DeliveryMethod;
import com.ccolleto.messagedelivery.service.DeliveryService;
import com.ccolleto.messagedelivery.service.MessageService;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private MessageService messageService;

	@Autowired
	private DeliveryMethod deliveryMethod;

	@Override
	public void deliveryMessages(LocalDateTime currentTime) {
		List<Message> messages = messageService.getMessagesToBeDelivered(currentTime);
		LocalDateTime deliveredAt = LocalDateTime.now();

		for (Message message : messages) {
			deliveryMethod.delivery(message, deliveredAt);
			messageService.markMessagesAsDelivered(message, deliveredAt);
		}

	}

}
