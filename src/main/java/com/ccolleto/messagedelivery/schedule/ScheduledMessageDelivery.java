package com.ccolleto.messagedelivery.schedule;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ccolleto.messagedelivery.service.DeliveryService;

@Component
public class ScheduledMessageDelivery {

	@Autowired
	private DeliveryService deliveryService;

	/**
	 * Task will be executed every minute and only messages scheduled for that time
	 * (or delayed due to server not available) will be delivered
	 */
	@Scheduled(fixedRate = 60 * 1000)
	public void deliveryMessages() {
		deliveryService.deliveryMessages(LocalDateTime.now());
	}

}
