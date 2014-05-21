package com.example;
/**
 * @author training
 * Demonstrates setter injection
 *
 */
public class HelloMessageEnglish implements HelloMessage {
	
	private String message;

	public HelloMessageEnglish (){
		this.message = "The quick brown fox";
	}
	
	void upCase(){
		this.message = this.message.toUpperCase();
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
