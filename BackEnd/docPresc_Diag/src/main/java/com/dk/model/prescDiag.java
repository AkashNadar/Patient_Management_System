package com.dk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name = "prescriptiondiagnosis")
public class prescDiag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prescId;
	
	@Column(nullable = false)
	private int patientId;
	
	@Column(nullable = false)
	private String prescDetails;
	
	@Column(nullable = false)
	private int diagnosisId;
	
	@Column(nullable = false)
	private String diagnosisTitle;

	@Column(nullable = false)
	
	private String expertComments;
	
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

	public int getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public String getDiagnosisTitle() {
		return diagnosisTitle;
	}

	public void setDiagnosisTitle(String diagnosisTitle) {
		this.diagnosisTitle = diagnosisTitle;
	}

	public String getExpertComments() {
		return expertComments;
	}

	public void setExpertComments(String expertComments) {
		this.expertComments = expertComments;
	}
	
}
