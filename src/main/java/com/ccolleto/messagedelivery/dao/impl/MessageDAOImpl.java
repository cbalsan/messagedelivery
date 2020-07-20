package com.ccolleto.messagedelivery.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ccolleto.messagedelivery.dao.MessageDAO;
import com.ccolleto.messagedelivery.model.Message;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	private MongoTemplate template;

	public void add(Message message) {
		template.save(message);
	}
}
