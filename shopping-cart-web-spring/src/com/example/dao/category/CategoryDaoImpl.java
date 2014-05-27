package com.example.dao.category;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DaoException;
import com.example.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategories() throws SQLException, DaoException {
		Session session = sessionFactory.getCurrentSession();
		List<Category> categories = session.createQuery("FROM Category").list();
		return categories;
	}

	public void addCategory(Category category) throws SQLException, DaoException {
		Session session = sessionFactory.getCurrentSession();
		if(getCategory(category.getCategoryName()) == null){
			session.save(category);
		}
		else {
			throw new DaoException("Duplicate category name!");
		}
	}

	@SuppressWarnings("unchecked")
	public Category getCategory(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Category> categories = session.createQuery("FROM Category cat WHERE cat.categoryName ='" + name + "'").list();
		return categories.size() > 0 ? categories.get(0) : null;
	}
}
