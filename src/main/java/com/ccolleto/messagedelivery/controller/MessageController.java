package com.ccolleto.messagedelivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService service;

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Message add(@Valid @RequestBody Message message) {
		service.add(message);
		return message;
	}
}
