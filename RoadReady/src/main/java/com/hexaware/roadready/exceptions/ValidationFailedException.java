package com.hexaware.roadready.exceptions;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ValidationFailedException extends MethodArgumentNotValidException  {
	public ValidationFailedException(MethodParameter parameter, BindingResult bindingResult) {
		super(parameter, bindingResult);
		// TODO Auto-generated constructor stub
	}
}
