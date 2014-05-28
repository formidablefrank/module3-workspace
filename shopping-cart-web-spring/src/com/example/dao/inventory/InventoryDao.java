package com.example.dao.inventory;

import java.sql.SQLException;

import com.example.model.Category;
import com.example.model.Inventory;
import com.example.model.Product;
import com.example.dao.DaoException;

public interface InventoryDao {
	Inventory getInventory(Category category) throws SQLException, DaoException;
	Integer getAvailableQty(Product pro) throws SQLException, DaoException;
	void decreaseSupply(Product product, int quantity) throws SQLException, DaoException;
}
