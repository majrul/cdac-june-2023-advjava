package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;
import com.cdac.entity.Employee;
import com.cdac.util.JPAUtil;

public class GenericDao { //CommonDao, ApnaDao, SabkaDao, ...

	private EntityManager createEntityManager() {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	public void save(Object obj) {
		EntityManager em = null;
		try {
			em = createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(obj); //merge is a 2-in-1 method. can be used for insert and update both
			tx.commit();
		}
		finally {
			em.close();
		}
	}

	public Object findByPK(Class clazz, Object id) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Object obj = em.find(clazz, id);
			return obj;
		}
		finally {
			em.close();
		}
	}
	
	public <E> E findByPKV2(Class<E> clazz, Object id) {
		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			E e = em.find(clazz, id);
			return e;
		}
		finally {
			em.close();
		}
	}
}
