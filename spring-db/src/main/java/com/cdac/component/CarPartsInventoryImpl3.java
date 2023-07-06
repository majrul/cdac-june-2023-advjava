package com.cdac.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*
 * In  this  version, we will use Hibernate/JPA to communicate with the  Database
 * Spring will help us in creating the necessary objects required for using Hibernate/JPA
 */
@Component("carPartsInv3")
public class CarPartsInventoryImpl3 implements CarPartsInventory {

	//@Autowired doesn't works if you try to inject EntityManager object
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addNewPart(CarPart carPart) {
		em.persist(carPart);
	}
	
	public List<CarPart> getAvailableParts() {
		return em
				.createQuery("select c from CarPart c", CarPart.class)
				.getResultList();
	}

}
