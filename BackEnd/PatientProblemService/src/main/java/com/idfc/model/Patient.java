package com.idfc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name = "users")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int problemId;
	
	@Column(nullable = false)
	private String patientId;
	
	@Column(nullable = false)
	private String sympoms;
	
	@Column(nullable = false)
	private String pastMedHist;
	
	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getSympoms() {
		return sympoms;
	}

	public void setSympoms(String sympoms) {
		this.sympoms = sympoms;
	}

	public String getPastMedHist() {
		return pastMedHist;
	}

	public void setPastMedHist(String pastMedHist) {
		this.pastMedHist = pastMedHist;
	}


	
	
}
