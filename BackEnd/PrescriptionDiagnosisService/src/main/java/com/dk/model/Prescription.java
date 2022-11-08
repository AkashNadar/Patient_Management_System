package com.dk.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name = "prescription_details")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prescId;

	@Column(nullable = false)
	private int patientId;
	
	@Column(nullable = false)
	private String prescDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
	private Diagnosis diagnosis;
	
	public Prescription() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Prescription(int prescId, int patientId, String prescDetails, Diagnosis diagnosis) {
		super();
		this.prescId = prescId;
		this.patientId = patientId;
		this.prescDetails = prescDetails;
		this.diagnosis = diagnosis;
	}

	public int getPrescId() {
		return prescId;
	}

	public void setPrescId(int prescId) {
		this.prescId = prescId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPrescDetails() {
		return prescDetails;
	}

	public void setPrescDetails(String prescDetails) {
		this.prescDetails = prescDetails;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	
}