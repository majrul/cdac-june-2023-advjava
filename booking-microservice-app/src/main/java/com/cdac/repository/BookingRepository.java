package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
