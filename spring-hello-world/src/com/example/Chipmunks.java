package com.example;

import java.util.List;


public class Chipmunks {

	private List<String> names;

	public void setNames(List<String> names) {
		this.names = names;
	}
	
	public List<String> getNames(){
		return this.names;
	}

	public Chipmunks(List<String> names) {
		super();
		this.names = names;
	}
	
	public Chipmunks(){
		
	}
	
}
