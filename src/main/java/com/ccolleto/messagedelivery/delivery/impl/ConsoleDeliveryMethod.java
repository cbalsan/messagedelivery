package com.ccolleto.messagedelivery.delivery.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.delivery.DeliveryMethod;

@Component
public class ConsoleDeliveryMethod implements DeliveryMethod {

	private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Override
	public void delivery(Message message, LocalDateTime deliveredAt) {
		System.out.println(this.buildMessage(message, deliveredAt));
	}

	private String buildMessage(Message message, LocalDateTime deliveredAt) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Delivered at: ");
		strBuilder.append(deliveredAt.format(dateFormatter));
		strBuilder.append("\nScheduled delivery time: ");
		strBuilder.append(message.getDeliveryDate().format(dateFormatter));
		strBuilder.append("\nMessage: ");
		strBuilder.append(message.getText());
		return strBuilder.toString();
	}

}
