package com.ccolleto.messagedelivery.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ccolleto.messagedelivery.custom.annotation.validator.NotBeforeThanNowValidator;

@Constraint(validatedBy = NotBeforeThanNowValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBeforeThanNow {

	String message() default "Date/time must greater than current time";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
