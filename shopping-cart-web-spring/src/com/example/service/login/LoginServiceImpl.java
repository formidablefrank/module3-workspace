package com.example.service.login;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.DaoException;
import com.example.dao.user.UserDao;
import com.example.model.User;
import com.example.service.ServiceException;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	UserDao userDao;

	public User getUser(String username)
			throws ServiceException {
		User user = null;
		try {
			user = userDao.getUser(username);
		} catch (DaoException e) {
			throw new ServiceException("Error in connection");
		} catch (SQLException e) {
			throw new ServiceException("Error in SQL");
		}
		return user;
	}

	public int getKeyUser(User user) throws ServiceException {
		int id = 0;
		try {
			id = userDao.getKeyUser(user);
		} catch (DaoException e) {
			throw new ServiceException("Error in connection");
		} catch (SQLException e) {
			throw new ServiceException("Error in SQL");
		}
		return id;
	}

}
