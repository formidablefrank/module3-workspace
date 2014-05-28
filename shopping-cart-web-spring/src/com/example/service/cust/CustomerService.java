package com.example.service.cust;

import com.example.model.Cart;
import com.example.model.Category;
import com.example.model.Inventory;
import com.example.model.Product;
import com.example.model.User;
import com.example.service.ServiceException;

public interface CustomerService {
	Inventory viewProducts(Category category) throws ServiceException;
	void addToCart(User user, Product pro, int quantity) throws ServiceException;
	void removeFromCart(User user, Product pro, int quantity) throws ServiceException;
	void clearCart(User user) throws ServiceException;
	Cart getCartFromUser(User user) throws ServiceException;
	void checkOutCart(User user) throws ServiceException;
}
