package com.example.dao;

import com.example.model.User;

public interface LoginDao {
	boolean isValid(User user);
}
