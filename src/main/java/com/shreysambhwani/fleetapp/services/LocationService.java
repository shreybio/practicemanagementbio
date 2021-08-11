package com.shreysambhwani.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreysambhwani.fleetapp.models.Location;
import com.shreysambhwani.fleetapp.repositories.LocationRepository;


@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	//Return list of countries
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	//get by id
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}


}

