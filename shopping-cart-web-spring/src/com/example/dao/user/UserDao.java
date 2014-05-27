package com.example.dao.user;

import java.sql.SQLException;

import com.example.dao.DaoException;
import com.example.model.User;

public interface UserDao {
	User getUser(String username) throws DaoException, SQLException;
	int getKeyUser(User user) throws DaoException, SQLException;
}
