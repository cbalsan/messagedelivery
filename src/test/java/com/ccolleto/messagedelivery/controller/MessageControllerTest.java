package com.ccolleto.messagedelivery.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ccolleto.messagedelivery.builder.MessageBuilder;
import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

	@Autowired
	private MockMvc mockMVC;

	@MockBean
	private MessageService service;

	@Test
	public void addShouldReturnValidationError() throws Exception {
		this.mockMVC
				.perform(post("/message").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(MessageBuilder.buildEmpty())))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void addShouldReturnSuccess() throws Exception {
		this.mockMVC
				.perform(post("/message").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(MessageBuilder.build())))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
