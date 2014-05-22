package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DaoInterface;

@Service("service")
public class ServiceImpl implements ServiceInterface {
	
	@Autowired
	private DaoInterface dao;

	public String fetchData() {
		return dao.fetchData();
	}

}
