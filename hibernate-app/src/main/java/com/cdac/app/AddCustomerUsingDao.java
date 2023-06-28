package com.cdac.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class AddCustomerUsingDao {

	public static void main(String[] args) {		
		Customer customer = new Customer();
		customer.setName("Samruddhi");
		customer.setEmail("samruddhi@gmail.com");
		customer.setDateOfBirth(null); 
		customer.setCity("Mumbai");
		
		CustomerDao dao = new CustomerDao();
		dao.store(customer);
	}
}
