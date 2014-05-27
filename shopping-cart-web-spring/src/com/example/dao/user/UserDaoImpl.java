package com.example.dao.user;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DaoException;
import com.example.model.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User getUser(String username) throws DaoException,
			SQLException {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("FROM User WHERE username = '" + username + "'").list();
		if(users.isEmpty()){
			return null;
		} else {
			return users.get(0);
		}
	}

	public int getKeyUser(User user) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
