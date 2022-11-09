package com.idfc.dao;

import com.idfc.model.PatientProblem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientProblemRepository extends JpaRepository<PatientProblem, Long> {
	public PatientProblem findByPatientId(long id);
}
