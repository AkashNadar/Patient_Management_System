package com.dk.dao;

import com.dk.model.Prescription;

import org.springframework.data.jpa.repository.JpaRepository;

public interface prescDiagRepository extends JpaRepository<Prescription, Integer> {

}
