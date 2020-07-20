package com.ccolleto.messagedelivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService service;

	@PostMapping("")
	public void add(@Valid @RequestBody Message message) {
		service.add(message);
	}
}
