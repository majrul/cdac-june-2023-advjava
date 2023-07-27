package com.cdac.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.Status;

@FeignClient(name = "flight-microservice")
public interface FlightServiceProxy2 {

	@GetMapping("/flights/seats-available")
	public Status isBookingPossible(Map<String, Object> params);
		
	@PostMapping("/flights/block-seats")
	public Status blockSeats(Map<String, Object> params);

	public default Status confirmBookingPossible(String flightNo, LocalDate travelDate, int noOfSeats) {
		Map<String, Object> params = new HashMap<>();
		params.put("flightNo", flightNo);
		params.put("travelDate", travelDate);
		params.put("noOfSeats", noOfSeats);
		
		Status status = isBookingPossible(params);
		
		if(status.isStatus())
			status = blockSeats(params);

		return status;
	}

}
