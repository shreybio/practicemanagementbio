package com.shreysambhwani.fleetapp.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shreysambhwani.fleetapp.models.Patient;
import com.shreysambhwani.fleetapp.services.CountryService;
import com.shreysambhwani.fleetapp.services.PatientService;
import com.shreysambhwani.fleetapp.services.EmployeeTypeService;
import com.shreysambhwani.fleetapp.services.JobTitleService;
import com.shreysambhwani.fleetapp.services.StateService;

@Controller
public class PatientController {
	

	
	@Autowired	private PatientService patientService;
	@Autowired	private JobTitleService jobTitleService;
	@Autowired	private EmployeeTypeService employeeTypeService;
	@Autowired	private CountryService countryService;
	@Autowired	private StateService stateService;


	
	

	@GetMapping("/patients")
	public String getPatients(Model model, String keyword) {	
		
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());		
	    model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());			
		model.addAttribute("states", stateService.getStates());		

		if(keyword != null){
			model.addAttribute("patients",patientService.findByKeyword(keyword));
		}
		else 
		{
		     model.addAttribute("patients", patientService.getPatients());			
		}
		
		return "Patient";
	}	
	
	@GetMapping("/patientsFiltered")
	public String getPatientsFiltered(Model model, String keyword) {	
		
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());		
	    model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());			
		model.addAttribute("states", stateService.getStates());		

	   model.addAttribute("patients", patientService.getPatients());			

		
		return "PatientFiltered";
	}
	
	
	
	@PostMapping("/patients/addNew")
	public String addNew(Patient patient) {
		patientService.save(patient);
		return "redirect:/patients";
	}
	
	@RequestMapping("patients/findById")
	@ResponseBody
	public Optional<Patient> findById(int id) {
	  return patientService.findById(id);	
	}	
	
	@RequestMapping(value="/patients/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Patient patient) {
		patientService.save(patient);
		return "redirect:/patients";
	}
	
	@RequestMapping(value="/patients/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		patientService.delete(id);
		return "redirect:/patients";
	}
	

}
