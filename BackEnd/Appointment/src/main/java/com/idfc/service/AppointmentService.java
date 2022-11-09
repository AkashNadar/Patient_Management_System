package com.idfc.service;

import java.util.List;

import com.idfc.model.Appointment;


public interface AppointmentService {
	
	public Appointment addAppointment(Appointment Appointment);
	
	public List<Appointment> getAppointment();
	
	public Appointment getAppointmentById(int id);
	
	public Appointment updateAppointment(int appointmentId, String patientId);
	
	public Appointment updateAppointmentDate(int AppointmentId, String AppointmentDate);
	
	public Appointment updateAppointmentTime(int AppointmentId, String AppointmentTime);
	
	public Appointment updateAppointment(Appointment appointment);
	
	public String deleteUser(int id);

}
