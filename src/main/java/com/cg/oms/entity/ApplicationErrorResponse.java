package com.cg.oms.entity;

public class ApplicationErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;
	
	//Getters & Setters
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	//Constructors
	public ApplicationErrorResponse() {}
	
	public ApplicationErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	//toString method
	@Override
	public String toString() {
		return "ApplicationErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
	
}
