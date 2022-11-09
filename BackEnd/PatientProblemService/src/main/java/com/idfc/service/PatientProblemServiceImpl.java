package com.idfc.service;

import java.util.List;
import java.util.Optional;

import com.idfc.dao.PatientProblemRepository;
import com.idfc.model.PatientProblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientProblemServiceImpl implements PatientProblemService {
	
	@Autowired
	private PatientProblemRepository repo;

	@Override
	public PatientProblem addPatientProblem(PatientProblem patientProblem) {
		return this.repo.save(patientProblem);
	}

	@Override
	public List<PatientProblem> getPatientProblem() {
		return this.repo.findAll();
	}

	@Override
	public Optional<PatientProblem> getPatientProblemById(long id) {
		return this.repo.findById(id);
	}
	
	@Override
	public PatientProblem getPatientProblemByUserId(long id) {
		return repo.findByPatientId(id);
	}

	@Override
	public PatientProblem updatePatientProblem(PatientProblem patientProblem, long patientId) {
		PatientProblem resPatientProblem = repo.findByPatientId(patientId);
		if(resPatientProblem == null) {
			return null;
		}
		resPatientProblem.setPastMedHist(patientProblem.getPastMedHist());
		resPatientProblem.setSympoms(patientProblem.getSympoms());
		return repo.save(resPatientProblem);
	}

	@Override
	public String deletePatientProblem(long patientId) {
		PatientProblem res = repo.findByPatientId(patientId);
		this.repo.deleteById(res.getProblemId());
		return "Patient Problem deleted sucessfully";
	}

	

	

	
}
