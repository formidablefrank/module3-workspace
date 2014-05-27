package com.example.dao.category;

import java.sql.SQLException;
import java.util.List;

import com.example.model.Category;
import com.example.dao.DaoException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface CategoryDao {
	List<Category> getCategories() throws SQLException, DaoException;
	void addCategory(Category category) throws SQLException, DaoException;
	Category getCategory(String name);
}
