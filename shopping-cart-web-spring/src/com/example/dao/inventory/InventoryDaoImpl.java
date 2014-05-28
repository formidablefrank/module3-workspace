package com.example.dao.inventory;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DaoException;
import com.example.model.Category;
import com.example.model.Inventory;
import com.example.model.Product;

@Transactional
@Repository("inventoryDao")
public class InventoryDaoImpl implements InventoryDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Inventory getInventory(Category category) throws SQLException,
			DaoException {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("FROM Product pro WHERE pro.category.categoryName = '" + category.getCategoryName() + "'").list();
		List<Object> quantities = session.createSQLQuery("SELECT fld_inventory_qty FROM tbl_product").list();
		LinkedHashMap<Product, Integer> inventory = new LinkedHashMap<Product, Integer>();
		for(int i=0; i<products.size(); i++){
			inventory.put(products.get(i), (Integer) quantities.get(i));
		}
		return new Inventory(inventory);
	}

	public void decreaseSupply(Product product, int quantity)
			throws SQLException, DaoException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public Integer getAvailableQty(Product pro) throws SQLException, DaoException {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("FROM Product pro").list();
		List<Object> quantities = session.createSQLQuery("SELECT fld_inventory_qty FROM tbl_product").list();
		LinkedHashMap<Product, Integer> inventory = new LinkedHashMap<Product, Integer>();
		for(int i=0; i<products.size(); i++){
			inventory.put(products.get(i), (Integer) quantities.get(i));
		}
		return inventory.get(pro);
	}
}
