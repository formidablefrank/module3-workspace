package com.example.service.cust;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DaoException;
import com.example.dao.cart.CartDao;
import com.example.dao.inventory.InventoryDao;
import com.example.dao.user.UserDao;
import com.example.model.Cart;
import com.example.model.Category;
import com.example.model.Inventory;
import com.example.model.Product;
import com.example.model.User;
import com.example.service.ServiceException;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired InventoryDao inventoryDao;
	@Autowired CartDao cartDao;
	@Autowired UserDao userDao;

	public Inventory viewProducts(Category category) throws ServiceException {
		Inventory inventory = null;
		try {
			inventory = inventoryDao.getInventory(category);
		} catch (SQLException e) {
			throw new ServiceException(e);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return inventory;
	}

	public void addToCart(User user, Product product, int quantity) throws ServiceException {
		try {
			cartDao.addToCart(user, product, quantity);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public void removeFromCart(User user, Product product, int quantity) throws ServiceException {
		try {
			cartDao.removeFromCart(user, product, quantity);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public void clearCart(User user) throws ServiceException {
		try {
			cartDao.clearCart(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	public Cart getCartFromUser(User user) throws ServiceException {
		Cart cart = null;
		try {
			cart = cartDao.getCartFromUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return cart;
	}

	public void checkOutCart(User user) throws ServiceException {
		try {
			cartDao.checkOutCart(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
