package com.ccolleto.messagedelivery.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ccolleto.messagedelivery.dao.MessageDAO;
import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.dao.model.SearchCriteria;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	private MongoTemplate template;

	public void add(Message message) {
		template.save(message);
	}

	@Override
	public void update(Message message) {
		template.save(message);
	}

	@Override
	public List<Message> findAll(SearchCriteria searchCriteria) {
		Query query = new Query();
		query.addCriteria(Criteria.where("delivered").is(searchCriteria.isDelivered()));
		query.addCriteria(Criteria.where("deliveryDate").lte(searchCriteria.getToBeDeliveredAt()));

		return template.find(query, Message.class);
	}
}
