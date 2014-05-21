package com.example;

public class AopTarget implements AopTargetInterface {
	public String getMessage() {
		return "Hello from the AOP target method";
	}
}