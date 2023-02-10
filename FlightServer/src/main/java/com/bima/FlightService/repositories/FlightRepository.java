package com.bima.FlightService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bima.FlightService.Entity.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

  @Query(value = "SELECT * FROM Flight WHERE departure_airport_code LIKE %?1%", nativeQuery = true)
  List<Flight> findCode(String code);
	

}