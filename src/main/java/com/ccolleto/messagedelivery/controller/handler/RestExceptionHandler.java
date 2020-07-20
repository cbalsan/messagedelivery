package com.ccolleto.messagedelivery.controller.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ccolleto.messagedelivery.controller.handler.model.APIError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		APIError error = new APIError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Malformed JSON request",
				this.extractErrors(ex));
		return new ResponseEntity<Object>(error, error.getStatus());
	}

	private List<String> extractErrors(MethodArgumentNotValidException ex) {
		List<String> errors = new ArrayList<String>();

		for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
			errors.add(objectError.getDefaultMessage());
		}

		return errors;
	}

}
