package com.dk.service;

import java.util.List;
import java.util.Optional;

import com.dk.dao.diagRepository;
import com.dk.model.Diagnosis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class diagServiceImple implements diagService {
	
	@Autowired
	private diagRepository repo;

	public diagServiceImple(diagRepository repo) {
		super();
		this.repo = repo;
	}

	public diagServiceImple() {
		super();
		//TODO Auto-generated constructor stub
	}

	@Override
	public Diagnosis addDiagnosis(Diagnosis diagnosis) {
		return repo.save(diagnosis);
	}
	
	@Override
	public List<Diagnosis> getDiagnosis() {
		return this.repo.findAll();
	}
	
	@Override
	public Optional<Diagnosis> getDiagnosisById(int diagId) {
		return this.repo.findById(diagId);
	}
	
	@Override
	public String deleteDiagnosis(int diagId) {
		Optional<Diagnosis> resDiagnosis = repo.findById(diagId);
		if(resDiagnosis.get() == null) {
			return null;
		}
		this.repo.deleteById(diagId);
		return "Diagnosis deleted sucessfully";
	}
	
	@Override
	public Diagnosis updateDiagnosis(int diagId, String diagnosis) {
		Optional<Diagnosis> resDiagnosis = repo.findById(diagId);
		if(resDiagnosis.get() == null) {
			return null;
		}
		return this.repo.save(resDiagnosis.get());
	}
}