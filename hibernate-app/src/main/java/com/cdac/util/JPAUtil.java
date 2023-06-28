package com.cdac.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf;
	
	static {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			emf.close();
		}));
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf == null)
			emf = Persistence.createEntityManagerFactory("hibernate-app");
		return emf;
	}
}
