package com.example;

public class HelloMessageFrench implements HelloMessage {

	private String msg;
	@Override
	public String getMessage() {
		return "Bonjour tout le monde!";
	}

	public HelloMessageFrench(String msg){
		this.setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
