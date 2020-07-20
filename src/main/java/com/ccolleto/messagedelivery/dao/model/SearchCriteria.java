package com.ccolleto.messagedelivery.dao.model;

import java.time.LocalDateTime;

public class SearchCriteria {

	private boolean isDelivered;

	private LocalDateTime toBeDeliveredAt;

	public SearchCriteria(boolean isDelivered, LocalDateTime toBeDeliveredAt) {
		super();
		this.isDelivered = isDelivered;
		this.toBeDeliveredAt = toBeDeliveredAt;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public LocalDateTime getToBeDeliveredAt() {
		return toBeDeliveredAt;
	}

}
