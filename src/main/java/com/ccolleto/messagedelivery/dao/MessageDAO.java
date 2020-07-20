package com.ccolleto.messagedelivery.dao;

import java.util.List;

import com.ccolleto.messagedelivery.dao.model.Message;
import com.ccolleto.messagedelivery.dao.model.SearchCriteria;

public interface MessageDAO {

	/**
	 * Method responsible for add a message in the database
	 * 
	 * @param message
	 */
	void add(Message message);

	/**
	 * Method responsible for update a provided message
	 * 
	 * @param message
	 */
	void update(Message message);

	/**
	 * Find any message that matches the criteria provided
	 * 
	 * @param searchCriteria
	 * @return
	 */
	List<Message> findAll(SearchCriteria searchCriteria);
}
