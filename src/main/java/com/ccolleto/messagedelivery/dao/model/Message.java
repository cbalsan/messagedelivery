package com.ccolleto.messagedelivery.dao.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.ccolleto.messagedelivery.custom.annotation.NotBeforeThanNow;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Message {

	@Id
	private ObjectId id;

	@NotEmpty(message = "Text must not be empty")
	private String text;

	@NotNull(message = "DeliveryDate must not be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@NotBeforeThanNow
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime deliveryDate;

	private boolean delivered;

	private LocalDateTime deliveredAt;

	@JsonIgnore
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@JsonIgnore
	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	@JsonIgnore
	public LocalDateTime getDeliveredAt() {
		return deliveredAt;
	}

	public void setDeliveredAt(LocalDateTime deliveredAt) {
		this.deliveredAt = deliveredAt;
	}

}
