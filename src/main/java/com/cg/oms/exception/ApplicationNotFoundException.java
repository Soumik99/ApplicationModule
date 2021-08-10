package com.cg.oms.exception;

@SuppressWarnings("serial")
public class ApplicationNotFoundException extends RuntimeException {
	
	public ApplicationNotFoundException() {
		super();
	}
	
	public ApplicationNotFoundException(String message) {
		super(message);
	}
	
	public ApplicationNotFoundException(Throwable cause) {
		super(cause);
	}
}
