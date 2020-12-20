package com.pks.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImp implements PatientService{
	
	@Autowired
	Repository repository;
	

	@Override
	public void addPatient(Patient Patient) {
		// TODO Auto-generated method stub
		repository.save(Patient);
		
	}

	@Override
	public void updatepatient(Patient patient,long id) {
		// TODO Auto-generated method stub
		patient =repository.findById(id).orElseThrow();
		patient.setName(patient.getName());
		patient.setAge(patient.getAge());
		patient.setAddress(patient.getAddress());
		patient.setEmail(patient.getEmail());
		
		repository.save(patient);
		
	}

	@Override
	public Patient getPatient(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow();
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		List<Patient>patientList = new ArrayList<>();
		repository.findAll().forEach(patientList::add);
		
		return patientList;
	}

	@Override
	public void deletePatient(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
