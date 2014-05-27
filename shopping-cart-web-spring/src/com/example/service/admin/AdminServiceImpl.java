package com.example.service.admin;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DaoException;
import com.example.dao.category.CategoryDao;
import com.example.dao.inventory.InventoryDao;
import com.example.dao.product.ProductDao;
import com.example.model.Category;
import com.example.model.Inventory;
import com.example.model.Product;
import com.example.service.ServiceException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired CategoryDao categoryDao;
	@Autowired InventoryDao inventoryDao;
	@Autowired ProductDao productDao;

	public void addCategory(Category category) throws ServiceException {
		try {
			categoryDao.addCategory(category);
		} catch (SQLException e) {
			throw new ServiceException(e.getMessage());
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void addProduct(Product product, int quantity)
			throws ServiceException {
		try {
			productDao.addProduct(product, quantity);
		} catch (SQLException e) {
			throw new ServiceException(e.getMessage());
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Inventory viewProducts(Category category) throws ServiceException {
		Inventory inventory = null;
		try {
			inventory = inventoryDao.getInventory(category);
		} catch (SQLException e) {
			throw new ServiceException(e.getMessage());
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return inventory;
	}

	public List<Category> getCategories() throws ServiceException {
		List<Category> categoryList = null;
		try {
			categoryList = categoryDao.getCategories();
		} catch (SQLException e) {
			throw new ServiceException(e.getMessage());
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return categoryList;
	}

	public Category getCategory(String name) {
		Category cat = new Category();
		cat = categoryDao.getCategory(name);
		return cat;
	}

}
