package com.bima.FlightService.Controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.*;

import com.bima.FlightService.Entity.Flight;
import com.bima.FlightService.repositories.FlightRepository;


@RequestMapping("/flight")
@RestController
public class FlightController {


	private final FlightRepository flightRepository;

	public FlightController(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	@RequestMapping(path ="/id/{id}")
	public Flight getById(@PathVariable Integer id) {
		return flightRepository.findById(id).orElse(null);
	}


	@GetMapping("/getAllFlight")
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@GetMapping("/departure")
	@ResponseBody
	public List<Flight> getFlightByCode(@RequestParam String code) {
		return flightRepository.findCode(code);
	}

	@GetMapping("/getAllDepatureJKT")
	public List<Flight> getAllDepatureJKT() {
		Stream<Flight> airportStream = getAllFlights().stream();
		return airportStream.filter(x -> x.getDepartureAirportCode().equals("JKT")).toList();
	}

	@GetMapping("/getAllArrivalJKT")
	public List<Flight> getAllArrivalJKT() {
		Stream<Flight> airportStream = getAllFlights().stream();
		return airportStream.filter(x -> x.getArrivalAirportCode().equals("JKT")).toList();
	}

	@GetMapping("/{id}")
	public Flight getFlightById(@PathVariable int id) {
		return flightRepository.findById(id).orElse(null);
	}

	@PostMapping("/addFlight")
	public Flight addFlight(@RequestBody Flight flight) {
		return flightRepository.save(flight);
	}

	@PutMapping("/{id}")
	public Flight updateFlight(@PathVariable int id, @RequestBody Flight flight) {
		flight.setId(id);
		return flightRepository.save(flight);
	}

	@DeleteMapping("/{id}")
	public void deleteFlight(@PathVariable int id) {
		flightRepository.deleteById(id);
	}
}