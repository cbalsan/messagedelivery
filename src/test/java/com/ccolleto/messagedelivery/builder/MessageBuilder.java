package com.ccolleto.messagedelivery.builder;

import java.time.LocalDateTime;

import com.ccolleto.messagedelivery.dao.model.Message;

public class MessageBuilder {

	public static Message build() {
		Message message = new Message();
		message.setText("Text");
		message.setDeliveryDate(LocalDateTime.now());
		return message;
	}

	public static Message buildEmpty() {
		return new Message();
	}
}
