package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Train;
import com.cdac.repository.TrainRepository;

@Service
//@Component - even this is okay, there is no difference
public class TrainService {

	@Autowired
	private TrainRepository trainRepo;
	
	public void add(Train train) {
		trainRepo.save(train);
	}
	
	public List<Train> getTrains(String source, String destination) {
		return trainRepo.findBySourceAndDestination(source, destination);
	}
}
