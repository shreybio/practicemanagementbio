package com.shreysambhwani.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreysambhwani.fleetapp.models.Practice;
import com.shreysambhwani.fleetapp.repositories.PracticeRepository;

@Service
public class PracticeService {
	
	@Autowired
	private PracticeRepository practiceRepository;
	
	//Return list of employees
	public List<Practice> getPractices(){
		return practiceRepository.findAll();
	}
	
	//SAve new employee
	public void save(Practice practice) {
		practiceRepository.save(practice);
	}
	
	//get by id
	public Optional<Practice> findById(int id) {
		return practiceRepository.findById(id);
	}

	public void delete(Integer id) {
		practiceRepository.deleteById(id);
	}
	
	//Get employees by keyword
	public List<Practice> findByKeyword(String keyword){
		return practiceRepository.findByKeyword(keyword);
		
	}
}
