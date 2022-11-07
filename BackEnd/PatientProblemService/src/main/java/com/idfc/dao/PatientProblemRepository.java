package com.idfc.dao;

import com.idfc.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientProblemRepository extends JpaRepository<Patient, Integer> {
}
