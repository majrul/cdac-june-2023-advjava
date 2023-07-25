package com.cdac.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.BookingDetails;
import com.cdac.dto.FlightDetails;
import com.cdac.dto.Status;
import com.cdac.entity.Flight;
import com.cdac.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@PostMapping("/flights/add")
	public Status add(@RequestBody FlightDetails flightDetails) {
		flightService.addFlight(flightDetails);
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Flight added!");
		return status;
	}
	
	@GetMapping("/flights/{source}/{destination}/{date}")
	public List<Flight> getFlights(@PathVariable String source,
								   @PathVariable String destination,
								   @PathVariable LocalDate date) {
		return flightService.getAvailableFlights(source, destination, date);
	}
	
	@GetMapping("/flights/seats-available")
	public Status seatsAvailable(@RequestParam String flightNo,
								 @RequestParam LocalDate travelDate,
								 @RequestParam int noOfSeats) {
		Status status = new Status();
		status.setStatus(flightService.areSeatsAvailable(flightNo, travelDate, noOfSeats));
		return status;
	}
	
	@PostMapping("/flights/block-seats")
	public Status blockSeats(@RequestBody BookingDetails bookingDetails) {
		if(flightService.areSeatsAvailable(bookingDetails.getFlightNo(), bookingDetails.getTravelDate(), bookingDetails.getNoOfSeats())) {
				flightService.blockSeats(bookingDetails.getFlightNo(), bookingDetails.getTravelDate(), bookingDetails.getNoOfSeats());		
				Status status = new Status();
				status.setStatus(true);
				status.setMessageIfAny("Seats blocked!");
				return status;
		}
		else {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny("Notenough seats!");
			return status;
		}
	}
	
}
