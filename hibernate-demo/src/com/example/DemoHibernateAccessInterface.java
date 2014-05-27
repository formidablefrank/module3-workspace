package com.example;

public interface DemoHibernateAccessInterface {
	User getUserFromDatabase();
	void addUser(User user);
	void addBankAccount(BankAccount bankAccount);
	void addAccountHolder(AccountHolder accountHolder);
}
