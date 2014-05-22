package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginDao;
import com.example.model.User;

@Service("service")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao dao;
	
	public boolean isValid(User user) {
		return dao.isValid(user);
	}

}
