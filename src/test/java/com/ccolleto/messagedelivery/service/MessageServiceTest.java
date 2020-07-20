package com.ccolleto.messagedelivery.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccolleto.messagedelivery.builder.MessageBuilder;
import com.ccolleto.messagedelivery.dao.MessageDAO;
import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.dao.model.SearchCriteria;

@SpringBootTest
public class MessageServiceTest {

	@MockBean
	private MessageDAO dao;

	@Autowired
	private MessageService service;

	@Test
	public void addTest() {
		try {
			Message message = MessageBuilder.build();
			service.add(message);
			assertThat(true);
		} catch (Exception e) {
			assertThat(false);
		}
	}

	@Test
	public void getMessagesToBeDeliveredTest() {
		List<Message> messages = new ArrayList<Message>();
		messages.add(MessageBuilder.build());

		Mockito.when(dao.findAll(any(SearchCriteria.class))).thenReturn(messages);

		assertThat(service.getMessagesToBeDelivered(LocalDateTime.now()).size()).isEqualTo(1);
	}

	@Test
	public void markMessagesAsDeliveredTest() {
		try {
			Message message = MessageBuilder.build();
			service.markMessagesAsDelivered(message, LocalDateTime.now());
			assertThat(true);
		} catch (Exception e) {
			assertThat(false);
		}
	}
}
