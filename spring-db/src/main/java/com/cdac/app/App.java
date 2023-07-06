package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.CarPart;
import com.cdac.component.CarPartsInventory;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		
		CarPartsInventory cpInv = (CarPartsInventory) ctx.getBean("carPartsInv2");
		
		//entities/model classes are not instantiated using Spring
		CarPart carPart = new CarPart();
		carPart.setPartName("Seatbelt");
		carPart.setCarModel("Maruti 800");
		carPart.setPrice(1500);
		carPart.setQuantity(25);
		
		long ms1 = System.currentTimeMillis();
		cpInv.addNewPart(carPart);
		long ms2 = System.currentTimeMillis();
		System.out.println("Approx time taken : " + (ms2-ms1) + " ms");
	}
}
