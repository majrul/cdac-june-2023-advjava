package com.cdac;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.dto.FlightDetails;
import com.cdac.service.FlightService;

@SpringBootTest
class FlightMicroserviceAppApplicationTests {

	@Autowired
	private FlightService flightService;
	
	@Test
	void addFlight() {
		FlightDetails flightDetails = new FlightDetails();
		flightDetails.setFlightNo("VT-789");
		flightDetails.setSource("Mumbai");
		flightDetails.setDestination("Delhi");
		flightDetails.setStartDate(LocalDate.of(2023, 8, 1));
		flightDetails.setEndDate(LocalDate.of(2023, 12, 31));
		flightDetails.setDepartureTime(LocalTime.of(14,30));
		flightDetails.setArrivalTime(LocalTime.of(16, 30));
		flightDetails.setNoOfSeats(99);
		flightService.addFlight(flightDetails);
	}

}
