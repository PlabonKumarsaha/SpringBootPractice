package com.pks.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	
	@Autowired
	PatientService patientService;

	@PostMapping("/patient/add")
	public void addPatient(@RequestBody Patient Patient) {
		patientService.addPatient(Patient);
	}
	
	@GetMapping("/patients")
	public List<Patient> getallPatient() {
		return patientService.getAllPatient();
	}
	@PutMapping("/patient/update/{id}")
	public void update(@RequestBody Patient patient,@PathVariable long id) {
		patientService.updatepatient(patient,id);
	}
	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable long id) {
		return patientService.getPatient(id);
	}
	@DeleteMapping("/patients/delete/{id}")
	public void deleteMapping(@PathVariable long id) {
		patientService.deletePatient(id);
	}
}
