package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DemoHibernateAccess implements DemoHibernateAccessInterface{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserFromDatabase(){
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("FROM User").list();
		if(users.isEmpty()){
			return null;
		} else {
			return users.get(0);
		}
	}

	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	public void addBankAccount(BankAccount bankAccount) {
		Session session = sessionFactory.getCurrentSession();
		session.save(bankAccount);
	}

	public void addAccountHolder(AccountHolder accountHolder) {
		Session session = sessionFactory.getCurrentSession();
		session.save(accountHolder);
	}
}
