package com.cdac.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.CarPart;
import com.cdac.component.CarPartsInventory;
import com.cdac.component.CarPartsRepository;

public class App2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		
		CarPartsRepository cpRepo = ctx.getBean(CarPartsRepository.class);
		
		/*CarPart carPart = new CarPart();
		carPart.setPartName("Mirror");
		carPart.setCarModel("Maruti 800");
		carPart.setPrice(2500);
		carPart.setQuantity(25);
		
		cpRepo.save(carPart);*/
		
		List<CarPart> list = cpRepo.findAll();
		for(CarPart cp : list)  {
			System.out.println(cp);
		}
	}
}
