package com.example.dao.cart;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DaoException;
import com.example.model.Cart;
import com.example.model.Product;
import com.example.model.User;

@Transactional
@Repository("cartDao")
public class CartDaoImpl implements CartDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Cart getCartFromUser(User user) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		List<Cart> carts = session.createQuery("FROM Cart cart WHERE cart.user.username='" + user.getUsername() + "'").list();
		return carts.isEmpty() ? null : carts.get(0);
	}

	public void addToCart(User user, Product product, int quantity)
			throws DaoException {
		// TODO Auto-generated method stub
		
	}

	public void removeFromCart(User user, Product product, int quantity)
			throws DaoException {
		// TODO Auto-generated method stub
		
	}

	public void checkOutCart(User user) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	public void clearCart(User user) throws DaoException {
		// TODO Auto-generated method stub
		
	}
}
