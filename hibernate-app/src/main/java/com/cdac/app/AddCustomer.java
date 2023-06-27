package com.cdac.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;

public class AddCustomer {

	public static void main(String[] args) {		
		//Step 1. We need to create EntityManagerFactory object
		//During this step, META-INF/persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		//Step 2. We need to create EntityManager object
		//Think about EntityManager is like Statement object of JDBC
		//It will help us in performing SQL operations
		EntityManager em = emf.createEntityManager();
		//Step 3. We need to bind the EntityManager with a Transaction
		//This is needed to enforce ACID principles
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer customer = new Customer();
		customer.setName("John");
		customer.setEmail("john@gmail.com");
		customer.setDateOfBirth(null); //try this on your own
		customer.setCity("New York");
		
		em.persist(customer); //persist will generate insert query
		
		tx.commit();
		em.close();
		emf.close();
	}
}
