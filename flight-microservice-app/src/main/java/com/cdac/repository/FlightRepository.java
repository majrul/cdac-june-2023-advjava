package com.cdac.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	//public List<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, LocalDate date);
	
	@Query("select f from Flight f where f.source = ?1 and f.destination = ?2 and f.departureDate = ?3")
	public List<Flight> findByRoute(String source, String destination, LocalDate date);
	
	@Query("select count(f) from Flight f where f.flightNo = ?1 and f.departureDate = ?2 and f.noOfSeats >= ?3")
	public Long findIfSeatsAreAvailable(String flightNo, LocalDate date, int noOfSeats);
	
	@Query("update Flight f set f.noOfSeats = f.noOfSeats - ?3 where f.flightNo = ?1 and f.departureDate = ?2")
	@Modifying
	public void blockSeats(String flightNo, LocalDate date, int noOfSeats);
}
