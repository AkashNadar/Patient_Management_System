package com.idfc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "patient_problem_details")
public class PatientProblem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private long patientId;
	
	@Column(nullable = false)
	private String symptoms;
	
	@Column(nullable = false)
	private String pastMedHist;
	
	public long getProblemId() {
		return id;
	}

	public void setProblemId(int problemId) {
		this.id = problemId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getSympoms() {
		return symptoms;
	}

	public void setSympoms(String sympoms) {
		this.symptoms = sympoms;
	}

	public String getPastMedHist() {
		return pastMedHist;
	}

	public void setPastMedHist(String pastMedHist) {
		this.pastMedHist = pastMedHist;
	}

	public PatientProblem() {
		super();
		//TODO Auto-generated constructor stub
	}

	public PatientProblem(long id, long patientId, String sympoms, String pastMedHist) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.symptoms = sympoms;
		this.pastMedHist = pastMedHist;
	}
	
	
}
