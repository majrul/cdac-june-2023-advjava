package com.cdac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.entity.Train;
import com.cdac.repository.TrainRepository;

@SpringBootTest
class SpringBootIntroApplicationTests {

	@Autowired
	private TrainRepository trainRepo;
	
	@Test
	void addTrain() {
		Train train = new Train();
		train.setName("Tejas Express");
		train.setSource("Mumbai");
		train.setDestination("Delhi");
		train.setAvailableSeats(25);
		
		trainRepo.save(train);
	}

}
