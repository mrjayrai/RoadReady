package com.hexaware.roadready.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class InvalidDataException {
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(reason="Please Enter Valid Data",code=HttpStatus.FORBIDDEN)
	
	public void handleExp1(RuntimeException ex) {//alternate of catch block
		
		
	}
}
