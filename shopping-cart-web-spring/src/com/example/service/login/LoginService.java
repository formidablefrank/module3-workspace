package com.example.service.login;

import com.example.model.User;
import com.example.service.ServiceException;

public interface LoginService {
	User getUser(String username) throws ServiceException;
	int getKeyUser(User user) throws ServiceException;
}
