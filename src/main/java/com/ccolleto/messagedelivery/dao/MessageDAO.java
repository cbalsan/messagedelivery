package com.ccolleto.messagedelivery.dao;

import java.util.List;

import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.dao.model.SearchCriteria;

public interface MessageDAO {

	void add(Message message);

	void update(Message message);

	List<Message> findAll(SearchCriteria searchCriteria);
}
