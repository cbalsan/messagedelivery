package com.ccolleto.messagedelivery.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccolleto.messagedelivery.builder.MessageBuilder;
import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.delivery.DeliveryMethod;

@SpringBootTest
public class DeliveryServiceTest {

	@Autowired
	private DeliveryService service;

	@MockBean
	private MessageService messageService;

	@MockBean
	private DeliveryMethod deliveryMethod;

	@Test
	public void deliveryMessagesTest() {
		try {
			LocalDateTime currentTime = LocalDateTime.now();

			List<Message> messages = new ArrayList<Message>();
			messages.add(MessageBuilder.build());

			Mockito.when(messageService.getMessagesToBeDelivered(currentTime)).thenReturn(messages);

			service.deliveryMessages(currentTime);

			assertThat(true);
		} catch (Exception e) {
			assertThat(false);
		}
	}
}
