package com.example.service.cust;

import com.example.model.Category;
import com.example.model.Inventory;
import com.example.model.Product;
import com.example.model.User;
import com.example.service.ServiceException;

public interface CustomerService {
	Inventory viewProducts(Category category) throws ServiceException;
	void addToCart(User user, Product pro, int quantity);
}
