package com.idfc.Appointment.service;

import java.util.List;

import com.idfc.Appointment.dao.AppointmentRepository;
import com.idfc.Appointment.model.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository repo;
	
	public AppointmentServiceImpl(AppointmentRepository repo) {
		super();
		this.repo = repo;
	}

	public AppointmentServiceImpl() {
		super();
		//TODO Auto-generated constructor stub
	}

	@Override
	public Appointment addAppointment(Appointment appointment) {
		return this.repo.save(appointment);
	}

	@Override
	public List<Appointment> getAppointment() {
		return this.repo.findAll();
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		return this.repo.findById(appointmentId).get();
	}
	
	@Override
	public Appointment getAppointmentByPatientId(int patientId) {
		return this.repo.findByPatientId(patientId);
	}
	
	@Override
	public Appointment getAppointmentByDoctorEmail(String doctorEmail) {
		return this.repo.findByDoctorEmail(doctorEmail);
	}

/*
	@Override
	public Appointment updateAppointment(int appointmentId, String patientId) {
		Appointment resUser = this.getAppointmentById(appointmentId);
		if(resUser == null) {
			return null;
		}
		resUser.setPatientId(patientId);
		return this.repo.save(resUser);
	}
	*/
	
	@Override
	public Appointment updateAppointmentDate(int appointmentId, String appointmentDate) {
		Appointment resUser = this.repo.findById(appointmentId).get();
		if(resUser == null) {
			return null;
		}
		resUser.setAppointmentDate(appointmentDate);
		return this.repo.save(resUser);
	}
	
	@Override
	public Appointment updateAppointmentTime(int appointmentId, String appointmentTime) {
		Appointment resUser = this.repo.findById(appointmentId).get();
		if(resUser == null) {
			return null;
		}
		resUser.setAppointmentTime(appointmentTime);
		return this.repo.save(resUser);
	}

	
	@Override
	public Appointment updateAppointment(Appointment appointment, int appointmentId) {
		Appointment resAppointment = this.repo.findById(appointmentId).get();
		if(resAppointment == null) {
			return null;
		}
		resAppointment.setPatientId(appointment.getPatientId());
		resAppointment.setDoctorEmail(appointment.getDoctorEmail());
		resAppointment.setAppointmentDate(appointment.getAppointmentDate());
		resAppointment.setAppointmentTime(appointment.getAppointmentTime());
		return this.repo.save(resAppointment);
	}

	@Override
	public String deleteAppointment(int appointmentId) {
		Appointment resUser = this.repo.findById(appointmentId).get();
		if(resUser == null) {
			return null;
		}
		this.repo.deleteById(appointmentId);
		return "Appointment deleted sucessfully";
	}	
}