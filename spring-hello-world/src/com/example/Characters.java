package com.example;

import java.util.List;
import java.util.Map;

public class Characters {

	private Map<String, List<String>> characters;
	
	private Characters(){
		
	}

	public Map<String, List<String>> getCharacters() {
		return characters;
	}

	public void setCharacters(Map<String, List<String>> characters) {
		this.characters = characters;
	}
}
