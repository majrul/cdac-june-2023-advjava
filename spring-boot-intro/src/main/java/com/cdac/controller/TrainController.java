package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Train;
import com.cdac.service.TrainService;

@RestController
@CrossOrigin //required for our frontend code which will be running on different server to be able to communicate with our backend rest api
public class TrainController {

	@Autowired
	private TrainService trainService;
	
	//http://localhost:9090/trains?source=Mumbai&destination=Delhi
	//@RequestMapping("/trains")
	@GetMapping("/trains")
	public List<Train> get(@RequestParam String source, @RequestParam String destination) {
		return trainService.getTrains(source, destination);
	}
	
	//localhost:9090/add-train
	//In the Body section in Postman, we need to send the data like this:
	/*
	 {
	    "name" : "Ndls Garibrath Express",
	    "departureTime" : "11:30:00",
	    "arrivalTime" : "08:00:00",
	    "source" : "Mumbai",
	    "destination" : "Delhi"
	}
	*/
	@PostMapping("/add-train")
	public String add(@RequestBody Train train) {
		trainService.add(train);
		return "Train details added successfully!";
	}
}
