package com.ccolleto.messagedelivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccolleto.messagedelivery.dao.MessageDAO;
import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO dao;

    @Override
    public void add(Message message) {
        dao.add(message);
    }
}
