package com.ccolleto.messagedelivery.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ccolleto.messagedelivery.dao.model.Message;

public interface MessageService {

	/**
	 * Add valid message. Controller validates the object contains the correct
	 * information to be used
	 * 
	 * @param message
	 */
	void add(Message message);

	/**
	 * Returns all messages that should be delivered at the schedule time The method
	 * also takes into account any message in the past that was not delivered
	 * 
	 * @param currentTime
	 * @return List<Message>
	 */
	List<Message> getMessagesToBeDelivered(LocalDateTime currentTime);

	/**
	 * Mark the messages delivered with isDelivered = true and deliveredAt = current
	 * time
	 * 
	 * @param messages
	 */
	void markMessagesAsDelivered(Message message, LocalDateTime deliveredAt);
}
