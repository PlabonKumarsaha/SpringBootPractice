package com.pks.rest;
import java.util.List;

import com.pks.rest.Patient;
public interface PatientService {

	void addPatient(Patient Patient);
	void updatepatient(Patient patient, long id);
	Patient getPatient(long id);
	List<Patient>getAllPatient();
	void deletePatient(long id);
	
	
}
