package com.learn.microservices.restfulservices.exception;

import java.util.Date;

public class ExceptionResponse {

	//time stamp
	//message
	//details
	
	private Date timestamp;
	private String message;
	private String details;
	
	
	
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
	
	
}