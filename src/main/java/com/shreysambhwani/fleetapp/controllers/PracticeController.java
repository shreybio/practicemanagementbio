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

import com.shreysambhwani.fleetapp.models.Practice;
import com.shreysambhwani.fleetapp.services.CountryService;
import com.shreysambhwani.fleetapp.services.PracticeService;
import com.shreysambhwani.fleetapp.services.EmployeeTypeService;
import com.shreysambhwani.fleetapp.services.JobTitleService;
import com.shreysambhwani.fleetapp.services.StateService;

@Controller
public class PracticeController {
	

	
	@Autowired	private PracticeService practiceService;
	@Autowired	private JobTitleService jobTitleService;
	@Autowired	private EmployeeTypeService employeeTypeService;
	@Autowired	private CountryService countryService;
	@Autowired	private StateService stateService;


	
	

	@GetMapping("/practices")
	public String getEmployees(Model model, String keyword) {	
		
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());		
	    model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());			
		model.addAttribute("states", stateService.getStates());		

		if(keyword != null){
			model.addAttribute("practices", practiceService.findByKeyword(keyword));
		}
		else 
		{
		     model.addAttribute("practices", practiceService.getEmployees());			
		}
		
		return "Practice";
	}	
	
	@GetMapping("/practicesFiltered")
	public String getEmployeesFiltered(Model model, String keyword) {	
		
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());		
	    model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());			
		model.addAttribute("states", stateService.getStates());		

	   model.addAttribute("practices", practiceService.getEmployees());			

		
		return "practicesFiltered";
	}
	
	
	
	@PostMapping("/practices/addNew")
	public String addNew(Practice practice) {
		practiceService.save(practice);
		return "redirect:/practices";
	}
	
	@RequestMapping("practices/findById")
	@ResponseBody
	public Optional<Practice> findById(int id) {
	  return practiceService.findById(id);	
	}	
	
	@RequestMapping(value="/practices/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Practice practice) {
		practiceService.save(practice);
		return "redirect:/employees";
	}
	
	@RequestMapping(value="/practices/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		practiceService.delete(id);
		return "redirect:/employees";
	}
	

}
