package com.cdac.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Customer;

public class FetchCustomers {

	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-app");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		//for fetching multiple customer data, we need to write
		//SELECT query. The syntax of writing SELECT query is a bit
		//different from SQL. It's called as HQL/JPQL
		//Hibernate will read the HQL/JPQL that we wrote and generate the SQL from it
		//Query q = em.createQuery("select c from Customer c"); //Equivalent to: select * from tbl_customer
		//Query q = em.createQuery("select c from Customer c where c.city = 'Mumbai'");
		//Query q = em.createQuery("select c from Customer c where c.email like '%yahoo%'");
		//Query q = em.createQuery("select c from Customer c where year(c.dateOfBirth) = 2001");
		//how can we substitute values in the query at the runtime?
		Query q = em.createQuery("select c from Customer c where c.city = :ct"); //named parameter
		q.setParameter("ct", "Pune"); //substituting parameter with some value
		List<Customer> list = q.getResultList();
		for(Customer customer : list) {
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
			System.out.println(customer.getDateOfBirth());
			System.out.println(customer.getCity());
			System.out.println("------------------");
		}		
		
		tx.commit();
		em.close();
		emf.close();
	}
}
