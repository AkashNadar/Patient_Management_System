package com.dk.service;

import java.util.List;
import java.util.Optional;

import com.dk.dao.prescRepository;
import com.dk.model.Prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class prescServiceImple implements prescService {
	
	@Autowired
	private prescRepository repo;

	public prescServiceImple(prescRepository repo) {
		super();
		this.repo = repo;
	}

	public prescServiceImple() {
		super();
		//TODO Auto-generated constructor stub
	}

	@Override
	public Prescription addPrescription(Prescription prescription) {
		return repo.save(prescription);
	}
	
	@Override
	public List<Prescription> getPrescription() {
		return this.repo.findAll();
	}
	
	@Override
	public Optional<Prescription> getPrescriptionById(int prescId) {
		return this.repo.findById(prescId);
	}
	
	@Override
	public String deletePrescription(int prescId) {
		Optional<Prescription> resPrescription = repo.findById(prescId);
		if(resPrescription.get() == null) {
			return null;
		}
		this.repo.deleteById(prescId);
		return "Prescription deleted sucessfully";
	}
	
	@Override
	public Prescription updatePrescription(int prescId, String prescription) {
		Optional<Prescription> resPrescription = repo.findById(prescId);
		if(resPrescription.get() == null) {
			return null;
		}
		return this.repo.save(resPrescription.get());
	}
}