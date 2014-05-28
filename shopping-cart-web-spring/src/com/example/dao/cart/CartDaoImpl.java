package com.example.dao.cart;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DaoException;
import com.example.dao.inventory.InventoryDao;
import com.example.model.Cart;
import com.example.model.OrderDetail;
import com.example.model.Product;
import com.example.model.User;

@Transactional
@Repository("cartDao")
public class CartDaoImpl implements CartDao {
	private SessionFactory sessionFactory;
	
	@Autowired InventoryDao inventoryDao;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Cart getCartFromUser(User user) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		List<OrderDetail> orders = session.createQuery("FROM OrderDetail od WHERE od.cart.user.username = '" + user.getUsername() + "'").list();
		Cart cart = orders.get(0).getCart();
		cart.setOrders(orders);
		return cart;
	}

	public void addToCart(User user, Product product, int quantity)
			throws DaoException {
		// TODO Auto-generated method stub
		
	}

	public void removeFromCart(User user, Product product, int quantity)
			throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public void checkOutCart(User user) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<OrderDetail> orders = session.createQuery("FROM OrderDetail od WHERE od.cart.user.username = '" + user.getUsername() + "'").list();
		for(OrderDetail order: orders){
			Integer available = 0;
			try {
				available = inventoryDao.getAvailableQty(order.getProduct());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(order.getOrderQuantity() <= available){
				
			}
		}
		tx.commit();
	}

	public void clearCart(User user) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		int res = session.createQuery("DELETE FROM OrderDetail od WHERE od.cart.user.username='" + user.getUsername() + "'").executeUpdate();
		System.out.println(res);
		res = session.createQuery("DELETE FROM Cart cart WHERE cart.user.username='" + user.getUsername() + "'").executeUpdate();
		System.out.println(res);
	}
}
