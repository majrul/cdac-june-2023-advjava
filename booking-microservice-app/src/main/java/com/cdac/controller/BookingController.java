package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.BookingDetails;
import com.cdac.dto.Status;
import com.cdac.exception.BookingException;
import com.cdac.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/bookings/book-flight")
	public Status book(@RequestBody BookingDetails bookingDetails) {
		try {
			int bookingId = bookingService.bookFlight(bookingDetails);
		
			Status status = new Status();
			status.setStatus(true);
			status.setMessage("Booking successful!");
			status.setBookingId(bookingId);
			
			return status;
		}
		catch(BookingException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
