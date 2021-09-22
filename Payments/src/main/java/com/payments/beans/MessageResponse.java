package com.payments.beans;

public class MessageResponse {
	private String message;
	private String tid;
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public MessageResponse(String message) {
		super();
		this.message = message;
	
	}

	public MessageResponse(String message, String tid) {
		this.message=message;
		this.tid=tid;
	}

	public MessageResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
