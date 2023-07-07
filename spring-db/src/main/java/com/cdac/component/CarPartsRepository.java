package com.cdac.component;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

//public interface CarPartsRepository extends CrudRepository<CarPart, Integer> { //Entity-Type,PK-Type
public interface CarPartsRepository extends JpaRepository<CarPart, Integer> { //Entity-Type,PK-Type
	
	@Query("select c from CarPart c where c.carModel like %?1%")
	public List<CarPart> findByCarModel(String carModel);
	
	public List<CarPart> findByPriceAndQuantity(double price, int quantity);
	
	@Query("select c from CarPart c where c.quantity > 0")
	public List<CarPart> findInStockParts();
	
	//@Query("select c from CarPart c where c.price between 1000 and 2000")
	@Query("select c from CarPart c where c.price between ?1 and ?2") //?1 and ?2 are reference to the method arguments
	public List<CarPart> findByPriceInRange(double min, double max);	
	
	@Query("update CarPart c set c.manufacturer=?1")
	@Modifying
	@Transactional
	public void updateManufacturerForAll(String name);
}
