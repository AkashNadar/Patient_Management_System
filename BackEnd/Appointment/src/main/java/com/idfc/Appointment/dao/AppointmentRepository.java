package com.idfc.Appointment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idfc.Appointment.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>  {
	
	public Appointment findByDoctorEmail(String doctorEmail);
	public Appointment findByPatientId(int patientId);
}
