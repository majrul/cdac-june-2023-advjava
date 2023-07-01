package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cdac.entity.Address;
import com.cdac.entity.Customer;
import com.cdac.entity.Employee;
import com.cdac.util.JPAUtil;

//This is wrong. Each Entity will have it's own Dao
public class EmployeeAddressDao {

	public void store(Employee emp) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(emp);
			tx.commit();
		}
		finally {
			em.close();
		}
	}

	public void update(Employee emp) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(emp);
			tx.commit();
		}
		finally {
			em.close();
		}
	}
	
	public Employee findByPK(int id) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Employee emp = em.find(Employee.class, id);
			return emp;
		}
		finally {
			em.close();
		}
	}

	public void store(Address addr) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(addr);
			tx.commit();
		}
		finally {
			em.close();
		}
	}

}
