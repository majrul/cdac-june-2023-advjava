package com.cdac.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;

public class FetchCustomer {

	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//find will generate select query with where pk = ?
		Customer customer = em.find(Customer.class, 2);
		System.out.println(customer.getName());
		System.out.println(customer.getEmail());
		System.out.println(customer.getDateOfBirth());
		System.out.println(customer.getCity());
		
		tx.commit();
		em.close();
		emf.close();
	}
}
