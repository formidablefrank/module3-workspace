package com.example.dao.cart;

import com.example.model.Cart;
import com.example.model.Product;
import com.example.model.User;
import com.example.dao.DaoException;

public interface CartDao {
	Cart getCartFromUser(User user) throws DaoException;
	void addToCart(User user, Product product, int quantity) throws DaoException;
	void removeFromCart(User user, Product product, int quantity) throws DaoException;
	void checkOutCart(User user) throws DaoException;
	void clearCart(User user) throws DaoException;
}
