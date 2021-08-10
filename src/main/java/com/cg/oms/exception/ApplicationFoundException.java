package com.cg.oms.exception;

@SuppressWarnings("serial")
public class ApplicationFoundException extends RuntimeException{
	
	public ApplicationFoundException() {
		super();
	}
	
	public ApplicationFoundException(String message) {
		super(message);
	}
	public ApplicationFoundException(Throwable cause) {
		super(cause);
	}
}
