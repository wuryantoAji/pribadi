package com.apap.tutorial4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService  {
	@Autowired
	private FlightDb flightDb;

	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}

	@Override
	public FlightModel getFlightByFlightNumber(String flightNumber) {
		// TODO Auto-generated method stub
		return flightDb.findByFlightNumber(flightNumber);
	}
	
	
}
