package com.ccolleto.messagedelivery.delivery;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ccolleto.messagedelivery.builder.MessageBuilder;
import com.ccolleto.messagedelivery.delivery.impl.ConsoleDeliveryMethod;

@SpringBootTest
public class DeliveryMethodTest {

	private DeliveryMethod deliveryMethod;

	@Test
	public void deliveryTest() {
		this.deliveryMethod = new ConsoleDeliveryMethod();

		LocalDateTime dateTime = LocalDateTime.now();

		deliveryMethod.delivery(MessageBuilder.build(), dateTime);
	}
}
