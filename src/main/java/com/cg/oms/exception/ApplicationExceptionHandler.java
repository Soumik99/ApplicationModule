package com.cg.oms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.oms.entity.ApplicationErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<ApplicationErrorResponse> handleException(ApplicationNotFoundException exception){
		ApplicationErrorResponse error = new ApplicationErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 NOT FOUND
	}
	
	@ExceptionHandler(ApplicationFoundException.class)
	public ResponseEntity<ApplicationErrorResponse> handleException(ApplicationFoundException exception){
		ApplicationErrorResponse error = new ApplicationErrorResponse();
		
		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);  //409 CONFLICT
	}
}


