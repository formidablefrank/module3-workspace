package com.example;

import java.util.Properties;

public class USStates {

	private Properties stateNames;
	
	public USStates(){
		
	}
	
	public USStates(Properties stateNames){
		this.stateNames = stateNames;
	}

	public Properties getStateNames() {
		return stateNames;
	}

	public void setStateNames(Properties stateNames) {
		this.stateNames = stateNames;
	}
}
