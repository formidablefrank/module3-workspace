package com.example;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DemoHibernateAccessInterface demoHibernateAccess = (DemoHibernateAccessInterface) applicationContext.getBean("dataComponent");
		
		User user = demoHibernateAccess.getUserFromDatabase();
		System.out.println(user);
		AccountHolder accountHolder = new AccountHolder();
		accountHolder.setFirstName("Procopio");
		accountHolder.setLastName("Pahlak");
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNumber("1234");
		bankAccount.setBalance(new BigDecimal("0.00"));
		bankAccount.setAccountHolder(accountHolder);
		
		demoHibernateAccess.addBankAccount(bankAccount);
	}

}
