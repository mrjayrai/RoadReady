package com.hexaware.roadready.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentNotFoundException {
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(reason="PaymentNotFound for that given id",code=HttpStatus.FORBIDDEN)
	
	public void handleExp1(NullPointerException ex) {//alternate of catch block
		
		
	}

}
