package com.cdac.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface CarPartsRepository extends CrudRepository<CarPart, Integer> { //Entity-Type,PK-Type
public interface CarPartsRepository extends JpaRepository<CarPart, Integer> { //Entity-Type,PK-Type
	
}
