package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImplementation implements DaoInterface{

	public String fetchData() {
		return "Data from the DAO";
	}
	
}
