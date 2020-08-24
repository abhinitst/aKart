package com.abhi.aKart.Exception;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
@Validated
public class CustomResponseEntity extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setDetails(req.getDescription(false));
		exceptionResponse.setMsg(ex.getMessage());
		exceptionResponse.setTimeStamp(new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

	@ExceptionHandler(categoryDataEmptyException.class)
	public final ResponseEntity<Object> handleAllExceptionCategory(Exception ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setDetails(req.getDescription(false));
		exceptionResponse.setMsg(ex.getMessage());
		exceptionResponse.setTimeStamp(new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

	}
	
	
	@ExceptionHandler(imageSizeException.class)
	public final ResponseEntity<Object> handleSizeExceptionCategory(Exception ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setDetails(req.getDescription(false));
		exceptionResponse.setMsg(ex.getMessage());
		exceptionResponse.setTimeStamp(new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

	}

	/*
	 * @ExceptionHandler(ConstraintViolationException.class)
	 * 
	 * @Override public final ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest reques) { Map<String, Object> body =
	 * new LinkedHashMap<>(); body.put("timestamp", new Date()); body.put("status",
	 * status.value());
	 * 
	 * // Get all errors java.util.List<String> errors =
	 * ex.getBindingResult().getFieldErrors().stream().map(x ->
	 * x.getDefaultMessage()) .collect(Collectors.toList());
	 * 
	 * body.put("errors", errors);
	 * 
	 * return new ResponseEntity<Object>(body, headers, status);
	 * 
	 * }
	 */

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> handle(ConstraintViolationException exception) {
		return error(exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.toList()));
	}

	private Map<String, Object> error(Object message) {
		return Collections.singletonMap("error", message);
	}

}
