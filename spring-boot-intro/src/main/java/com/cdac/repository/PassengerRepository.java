package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
