package com.cupakitodo.rest.basic.auth;

public class AuthenticationBean {

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

	public AuthenticationBean(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", message);
	}
	
	

}
