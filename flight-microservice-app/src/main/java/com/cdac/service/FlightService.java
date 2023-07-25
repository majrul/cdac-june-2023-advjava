package com.cdac.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dto.FlightDetails;
import com.cdac.entity.Flight;
import com.cdac.repository.FlightRepository;

@Service
@Transactional
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public void addFlight(FlightDetails flightDetails) {
		LocalDate startDate = flightDetails.getStartDate();
		LocalDate endDate = flightDetails.getEndDate();
		
		long noOfDays = ChronoUnit.DAYS.between(startDate, endDate);
		for(int i=0; i<noOfDays; i++) {
			Flight flight = new Flight();
			BeanUtils.copyProperties(flightDetails, flight);
			flight.setDepartureDate(startDate);
			flightRepository.save(flight);
			startDate = startDate.plus(1, ChronoUnit.DAYS);
		}
	}
	
	public List<Flight> getAvailableFlights(String source, String destination, LocalDate date) {
		return flightRepository.findByRoute(source, destination, date);
	}
	
	public boolean areSeatsAvailable(String flightNo, LocalDate date, int noOfSeats) {
		return flightRepository.findIfSeatsAreAvailable(flightNo, date, noOfSeats) == 1;
//		if(flightRepository.findIfSeatsAreAvailable(flightNo, date, noOfSeats) == 1)
//			return true;
//		else
//			return false;
	}
	
	public void blockSeats(String flightNo, LocalDate date, int noOfSeats) {
		flightRepository.blockSeats(flightNo, date, noOfSeats);
	}
	
}
