package com.example.service.admin;

import java.util.List;

import com.example.model.Category;
import com.example.model.Inventory;
import com.example.model.Product;
import com.example.service.ServiceException;

public interface AdminService {
	void addCategory(Category category) throws ServiceException;
	void addProduct(Product product, int quantity) throws ServiceException;
	Category getCategory(String name);
	List<Category> getCategories() throws ServiceException;
	Inventory viewProducts(Category category) throws ServiceException;
}
