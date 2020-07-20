package com.ccolleto.messagedelivery.delivery;

import java.time.LocalDateTime;

import com.ccolleto.messagedelivery.dao.model.Message;

public interface DeliveryMethod {

	void delivery(Message message, LocalDateTime deliveredAt);
}