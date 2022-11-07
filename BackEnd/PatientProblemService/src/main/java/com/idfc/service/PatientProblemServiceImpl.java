package com.idfc.service;

import java.util.List;

import com.idfc.dao.PatientProblemRepository;
import com.idfc.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientProblemServiceImpl implements PatientProblemService {
	
	@Autowired
	private PatientProblemRepository repo;

	@Override
	public Patient addPatient(Patient patient) {
		if(patient != null) {
			return null;
		}
		return this.repo.save(patient);
	}

	@Override
	public List<Patient> getPatient() {
		return this.repo.findAll();
	}

	@Override
	public Patient getProblemById(int id) {
		return this.repo.findById(id).get();
	}


	@Override
	public Patient updatePatient(int problemId, String patientId) {
		Patient resUser = this.getProblemById(problemId);
		if(resUser == null) {
			return null;
		}
		resUser.setPatientId(patientId);
		return this.repo.save(resUser);
	}
	
	@Override
	public Patient updateSympoms(int problemId, String sympoms) {
		Patient resUser = this.getProblemById(problemId);
		if(resUser == null) {
			return null;
		}
		resUser.setSympoms(sympoms);
		return this.repo.save(resUser);
	}

	
	@Override
	public Patient updatePatient(Patient patient) {
		Patient updatePatient = this.getProblemById(patient.getProblemId());
		updatePatient.setPastMedHist(patient.getPastMedHist());
		updatePatient.setProblemId(patient.getProblemId());
		updatePatient.setSympoms(patient.getSympoms());
		updatePatient.setPatientId(patient.getPatientId());
		return null;
	}

	@Override
	public String deleteUser(int id) {
		Patient resUser = this.getProblemById(id);
		if(resUser == null) {
			return null;
		}
		this.repo.deleteById(id);
		return "User deleted sucessfully";
	}

	

	
}
