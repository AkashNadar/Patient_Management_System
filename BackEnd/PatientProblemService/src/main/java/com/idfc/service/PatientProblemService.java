package com.idfc.service;

import java.util.List;

import com.idfc.model.Patient;


public interface PatientProblemService {

	public Patient addPatient(Patient user);
	
	public List<Patient> getPatient();
	
	public Patient getProblemById(int id);
	
	public Patient updatePatient(int problemId, String patientId);
	
	public Patient updateSympoms(int problemId, String sympoms);
	
	public Patient updatePatient(Patient patient);
	
	public String deleteUser(int id);
}
