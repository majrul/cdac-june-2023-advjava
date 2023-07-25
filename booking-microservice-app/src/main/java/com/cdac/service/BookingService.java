package com.cdac.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.BookingDetails;
import com.cdac.dto.Status;
import com.cdac.entity.Booking;
import com.cdac.exception.BookingException;
import com.cdac.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private FlightServiceProxy flightServiceProxy;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public int bookFlight(BookingDetails bookingDetails) {
		Status status = flightServiceProxy.confirmBookingPossible(
														bookingDetails.getFlightNo(), 
														bookingDetails.getTravelDate(), 
														bookingDetails.getPassengers().size());
		if(status.isStatus()) {
			Booking booking = new Booking();
			BeanUtils.copyProperties(bookingDetails, booking);
			booking.setBookingDate(LocalDate.now());
			booking.setNoOfSeats(bookingDetails.getPassengers().size());
			bookingRepository.save(booking);
			return booking.getId();
		}
		throw new BookingException("Booking failed, not enough seats!");
	}
}
