package com.apap.tutorial5.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
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

	@Override
	public void deleteFlight(FlightModel flight) {
		// TODO Auto-generated method stub
		flightDb.delete(flight);
		
	}

	@Override
	public void deleteFlightbyId(long flightId) {
		// TODO Auto-generated method stub
		flightDb.deleteById(flightId);
	}

}
