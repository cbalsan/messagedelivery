package com.ccolleto.messagedelivery.delivery;

import java.time.LocalDateTime;

import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.delivery.impl.ConsoleDeliveryMethod;

public interface DeliveryMethod {

	/**
	 * Represents the abstraction of possible delivery methods Possible
	 * implementations: {@link ConsoleDeliveryMethod}
	 * 
	 * @param message
	 * @param deliveredAt
	 */
	void delivery(Message message, LocalDateTime deliveredAt);
}