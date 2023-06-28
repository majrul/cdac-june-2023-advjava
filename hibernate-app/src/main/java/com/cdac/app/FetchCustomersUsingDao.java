package com.cdac.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class FetchCustomersUsingDao {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		//List<Customer> list = dao.findAll();
		List<Customer> list = dao.findByCity("Mumbai");
		for(Customer customer : list) {
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
			System.out.println(customer.getDateOfBirth());
			System.out.println(customer.getCity());
			System.out.println("------------------");
		}		
		
	}
}
