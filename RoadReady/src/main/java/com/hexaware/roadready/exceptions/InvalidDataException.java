package com.hexaware.roadready.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class InvalidDataException extends ResponseStatusException {

	public InvalidDataException(HttpStatusCode status,String message) {
		super(status,message);
		// TODO Auto-generated constructor stub
	}

}
