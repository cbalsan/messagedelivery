package com.ccolleto.messagedelivery.service;

import java.time.LocalDateTime;

public interface DeliveryService {

	void deliveryMessages(LocalDateTime currentTime);

}