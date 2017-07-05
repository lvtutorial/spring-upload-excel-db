package com.hlv.bean;

public class Message {
	//using bootstrap 3 then error is danger, refer to messages.tag file
	public static final String ERROR="error";  
	public static final String INFO="info";
	public static final String SUCCESS="success";
	public static final String WARNING="warning";
	
	private String status;
	private String message;
	private String field;
	public Message(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
	public Message(String status, String field, String message) {
		super();
		this.status = status;
		this.message = message;
		this.field = field;
	}


	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
