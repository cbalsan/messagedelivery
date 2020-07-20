package com.ccolleto.messagedelivery.custom.annotation.validator;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ccolleto.messagedelivery.custom.annotation.NotBeforeThanNow;

public class NotBeforeThanNowValidator implements ConstraintValidator<NotBeforeThanNow, LocalDateTime> {

	@Override
	public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
		return value != null && !value.isBefore(LocalDateTime.now());
	}

}
