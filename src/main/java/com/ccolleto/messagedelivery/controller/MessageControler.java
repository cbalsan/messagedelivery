package com.ccolleto.messagedelivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccolleto.messagedelivery.model.Message;
import com.ccolleto.messagedelivery.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageControler {

	@Autowired
	private MessageService service;

	@PostMapping("")
	public void add(@Valid @RequestBody Message message, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("error");
		}
		service.add(message);
	}
}
