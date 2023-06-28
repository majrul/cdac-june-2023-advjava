package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Customer;

//Data Access Object
//Classes which contain DB code are commonly referred to as Dao classes
//Dao is one of the design pattern we commonly use in projects
//Instead of Dao, we can also call this class as Repository class
public class CustomerDao {

	public void store(Customer customer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(customer); //persist will generate insert query
		
		tx.commit();
		em.close();
		emf.close();
	}
	
	public Customer findByPK(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer customer = em.find(Customer.class, 2);
		
		tx.commit();
		em.close();
		emf.close();

		return customer;
	}
	
	public List<Customer> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query q = em.createQuery("select c from Customer c");
		List<Customer> list = q.getResultList();
		
		tx.commit();
		em.close();
		emf.close();

		return list;
	}

	public List<Customer> findByCity(String city) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query q = em.createQuery("select c from Customer c where c.city = :ct");
		q.setParameter("ct", city); 
		List<Customer> list = q.getResultList();
		
		tx.commit();
		em.close();
		emf.close();

		return list;
	}
}
