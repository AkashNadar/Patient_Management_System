package com.idfc.service;

import java.util.List;

import com.idfc.dao.AppointmentRepository;
import com.idfc.model.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository repo;

	@Override
	public Appointment addAppointment(Appointment appointment) {
		if(appointment != null) {
			return null;
		}
		return this.repo.save(appointment);
	}

	@Override
	public List<Appointment> getAppointment() {
		return this.repo.findAll();
	}

	@Override
	public Appointment getAppointmentById(int id) {
		return this.repo.findById(id).get();
	}


	@Override
	public Appointment updateAppointment(int appointmentId, String patientId) {
		Appointment resUser = this.getAppointmentById(appointmentId);
		if(resUser == null) {
			return null;
		}
		resUser.setPatientId(patientId);
		return this.repo.save(resUser);
	}
	
	@Override
	public Appointment updateAppointmentDate(int appointmentId, String appointmentDate) {
		Appointment resUser = this.getAppointmentById(appointmentId);
		if(resUser == null) {
			return null;
		}
		resUser.setAppointmentDate(appointmentDate);
		return this.repo.save(resUser);
	}
	
	@Override
	public Appointment updateAppointmentTime(int appointmentId, String appointmentTime) {
		Appointment resUser = this.getAppointmentById(appointmentId);
		if(resUser == null) {
			return null;
		}
		resUser.setAppointmentTime(appointmentTime);
		return this.repo.save(resUser);
	}

	
	@Override
	public Appointment updateAppointment(Appointment appointment) {
		Appointment updateAppointment = this.getAppointmentById(appointment.getAppointmentId());
		updateAppointment.setAppointmentId(appointment.getAppointmentId());
		updateAppointment.setAppointmentDate(appointment.getAppointmentDate());
		updateAppointment.setAppointmentTime(appointment.getAppointmentTime());
		updateAppointment.setPatientId(appointment.getPatientId());
		return null;
	}

	@Override
	public String deleteUser(int id) {
		Appointment resUser = this.getAppointmentById(id);
		if(resUser == null) {
			return null;
		}
		this.repo.deleteById(id);
		return "User deleted sucessfully";
	}	
}