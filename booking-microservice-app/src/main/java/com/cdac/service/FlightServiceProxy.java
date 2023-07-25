package com.cdac.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cdac.dto.Status;

@Service
public class FlightServiceProxy {

	public Status confirmBookingPossible(String flightNo, LocalDate travelDate, int noOfSeats) {
		String url = "http://localhost:9001/flights/seats-available?flightNo={flightNo}&travelDate={travelDate}&noOfSeats={noOfSeats}";
		Map<String, Object> params = new HashMap<>();
		params.put("flightNo", flightNo);
		params.put("travelDate", travelDate);
		params.put("noOfSeats", noOfSeats);
		
		RestTemplate restTemplate = new RestTemplate();
		Status status = restTemplate.getForObject(url, Status.class, params);
		
		if(status.isStatus()) {
			url = "http://localhost:9001/flights/block-seats";
			status = restTemplate.postForObject(url, params, Status.class);
			
		}
		return status;
	}

}
