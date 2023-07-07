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
		carPart.setPartName("Seat Cover");
		carPart.setCarModel("Hyundai i10");
		carPart.setPrice(5000);
		carPart.setQuantity(99);
		carPart.setManufacturer("CarWale Accessories Pvt. Ltd.");
		
		cpRepo.save(carPart);*/
		
		//List<CarPart> list = cpRepo.findAll();
		//List<CarPart> list = cpRepo.findByCarModel("Hyundai");
		//List<CarPart> list = cpRepo.findByPriceAndQuantity(2500, 25);
		//List<CarPart> list = cpRepo.findInStockParts();
		//List<CarPart> list = cpRepo.findByPriceInRange(1000, 2000);
		/*for(CarPart cp : list)  {
			System.out.println(cp);
		}*/
		
		cpRepo.updateManufacturerForAll("CarWale Accessories Pvt. Ltd.");
	}
}
