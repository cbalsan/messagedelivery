package com.ccolleto.messagedelivery.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
public class Message {

	@Id
	private ObjectId id;

	@NotEmpty
	@NotNull
	private String text;

	@NotEmpty
	@NotNull
	private Date deliveryDate;

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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean delivered) {
		isDelivered = delivered;
	}
}
