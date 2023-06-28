package com.cdac.app;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class FetchCustomerUsingDao {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.findByPK(1);
		System.out.println(customer.getName());
		System.out.println(customer.getEmail());
		System.out.println(customer.getDateOfBirth());
		System.out.println(customer.getCity());
	}
}
