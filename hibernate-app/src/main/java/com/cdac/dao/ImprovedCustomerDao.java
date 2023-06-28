package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cdac.entity.Customer;
import com.cdac.util.JPAUtil;

public class ImprovedCustomerDao {

	public void store(Customer customer) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(customer);
			tx.commit();
		}
		finally {
			em.close();
		}
	}
	
	public Customer findByPK(int id) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Customer customer = em.find(Customer.class, id);
			return customer;
		}
		finally {
			em.close();
		}
	}
	
	public List<Customer> findAll() {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			Query q = em.createQuery("select c from Customer c");
			List<Customer> list = q.getResultList();
			return list;
		}
		finally {
			em.close();
		}
	}

	public List<Customer> findByCity(String city) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			Query q = em.createQuery("select c from Customer c where c.city = :ct");
			q.setParameter("ct", city); 
			List<Customer> list = q.getResultList();
			return list;
		}
		finally {
			em.close();
		}
	}
}
