package com.dk.service;

import java.util.List;
import java.util.Optional;

import com.dk.model.Diagnosis;

public interface diagService {

	public Diagnosis addDiagnosis(Diagnosis diagnosis);
	
	public String deleteDiagnosis(int diagId);
	
	public Diagnosis updateDiagnosis(int diagId, String diagnosis);
	
	public List<Diagnosis> getDiagnosis();
	
	public Optional<Diagnosis> getDiagnosisById(int diagId);
		
}
