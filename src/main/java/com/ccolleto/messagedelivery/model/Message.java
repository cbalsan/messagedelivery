package com.ccolleto.messagedelivery.model;

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

	@NotEmpty
	private String text;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@NotBeforeThanNow
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime deliveryDate;

	@JsonIgnore
	private boolean isDelivered;

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

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean delivered) {
		isDelivered = delivered;
	}
}
