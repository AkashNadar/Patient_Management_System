package com.dk.service;

import java.util.List;
import java.util.Optional;

import com.dk.model.prescDiag;


public interface prescDiagService {

	public prescDiag addPrescription(prescDiag prescription);
	
	public String deletePrescription(int prescId);
	
	public prescDiag updatePrescription(int prescId, String oldPresc, String newPresc);
	
	public prescDiag addDiagnosis(prescDiag diagnosis);
	
	public String deleteDiagnosis(int diagnosisId);
	
	public prescDiag updateDiagnosis(int diagnosisId, String oldDiagnosis, String newDiagnosis);
	
	public List<prescDiag> getPrescription();
	
	public List<prescDiag> getDiagnosis();
	
	public Optional<prescDiag> getPrescriptionById(int id);
	
	public prescDiag getUserByEmail(String email);
	
	
}
