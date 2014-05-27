package com.example.dao.product;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DaoException;
import com.example.model.Product;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao{
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Product getProduct(String name) throws DaoException, SQLException {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("FROM Product pro WHERE pro.productName='" + name + "'").list();
		return products.size() > 0 ? products.get(0) : null;
	}

	public int getInventoryQty(String name) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addProduct(Product pro, int quantity) throws DaoException,
			SQLException {
		Session session = sessionFactory.getCurrentSession();
		if(getProduct(pro.getProductName()) == null){
			session.save(pro);
			int result = session.createSQLQuery("UPDATE tbl_product SET fld_inventory_qty =" + quantity +" WHERE fld_product_name='" + pro.getProductName() + "';").executeUpdate();
			System.out.println(result);
		}
		else {
			throw new DaoException("Duplicate product name!");
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
