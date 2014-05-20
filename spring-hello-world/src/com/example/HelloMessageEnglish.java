package com.example;
/**
 * @author training
 * Demonstrates setter injection
 *
 */
public class HelloMessageEnglish implements HelloMessage {
	
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
