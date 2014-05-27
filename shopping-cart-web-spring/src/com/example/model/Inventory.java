package com.example.model;

import java.util.LinkedHashMap;


public class Inventory {
	private LinkedHashMap<Product, Integer> productList;

	public Inventory(){}
	
	public LinkedHashMap<Product, Integer> getProductList() {
		return productList;
	}

	public void setProductList(LinkedHashMap<Product, Integer> productList) {
		this.productList = productList;
	}

	public Inventory(LinkedHashMap<Product, Integer> productList) {
		super();
		this.productList = productList;
	}
	
}
