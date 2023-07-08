package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Integer>{

	//@Query("select t from Train t where t.source = ?1  and t.destination = ?2")
	public List<Train> findBySourceAndDestination(String source, String destination);
}
