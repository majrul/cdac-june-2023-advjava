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
	
	public Employee findByName(String name) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query q = em.createQuery("select e from Employee e where e.name = :nm");
			q.setParameter("nm", name);
			return (Employee) q.getSingleResult();
		}
		finally {
			em.close();
		}
	}

	public List<Employee> findByJoiningYear(int year) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query q = em.createQuery("select e from Employee e where year(e.dateOfJoining) = :yr");
			q.setParameter("yr", year);
			return q.getResultList();
		}
		finally {
			em.close();
		}
	}
	
	public List<Employee> findBySalary(double salary) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query q = em.createQuery("select e from Employee e where e.salary >= :sal");
			q.setParameter("sal", salary);
			return q.getResultList();
		}
		finally {
			em.close();
		}
	}
	
	/*
	 	SQL Query =>
	 	SELECT * FROM TBL_EMPLOYEE E
		JOIN TBL_ADDRESS A ON E.ADDR_ID = A.ADDR_ID
		WHERE A.CITY = 'Mumbai';
	 */
	public List<Employee> findByCity(String city) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query q = em.createQuery("select e from Employee e join e.address a where a.city = :ct");
			q.setParameter("ct", city);
			return q.getResultList();
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
