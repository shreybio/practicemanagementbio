package com.shreysambhwani.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreysambhwani.fleetapp.models.Employee;
import com.shreysambhwani.fleetapp.repositories.EmployeeRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	//Return list of employees
	public List<Patient> getPatients(){
		return patientRepository.findAll();
	}
	
	//SAve new employee
	public void save({Patient patient) {
		patientRepository.save(patient);
	}
	
	//get by id
	public Optional<Patient> findById(int id) {
		return patientRepository.findById(id);
	}

	public void delete(Integer id) {
		patientRepository.deleteById(id);
	}
	
	//Get employees by keyword
	public List<Patieny> findByKeyword(String keyword){
		return patientRepository.findByKeyword(keyword);
		
	}
}
