package com.bima.AirportServer.Controller;

import java.util.List;

import com.bima.AirportServer.Entity.Airport;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.bima.AirportServer.repositories.AirportRepository;

@RequestMapping("/airport")
@RestController
@AllArgsConstructor
public class AirportController {
	private final AirportRepository airportRepository;

	@PostMapping(path ="/add")
	public Airport add(@RequestBody Airport airport) {
		return airportRepository.save(airport);
	}

	@GetMapping("/getAllAirports")
	public List<Airport> getAllAirports() {
		return airportRepository.findAll();
	}

	@GetMapping("/{id}")
	public Airport getAirportById(@PathVariable int id) {
		return airportRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public Airport updateAirport(@PathVariable int id, @RequestBody Airport airport) {
		airport.setId(id);
		return airportRepository.save(airport);
	}

	@DeleteMapping("/{id}")
	public void deleteAirport(@PathVariable int id) {
		airportRepository.deleteById(id);
	}


}