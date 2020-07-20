package com.ccolleto.messagedelivery.service;

import java.time.LocalDateTime;

public interface DeliveryService {

	/**
	 * Delivery messages scheduled for the time provided
	 * @param currentTime
	 */
	void deliveryMessages(LocalDateTime currentTime);

}