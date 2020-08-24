package com.abhi.aKart.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class imageSizeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public imageSizeException(String message) {
		super(message);
	}
	
	
	
	

}
