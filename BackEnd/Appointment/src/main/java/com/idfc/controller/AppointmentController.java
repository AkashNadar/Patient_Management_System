package com.idfc.controller;

import java.util.List;
import java.util.Map;

import com.idfc.model.Appointment;
import com.idfc.service.AppointmentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentServiceImpl service;

	@PostMapping("/addAppointment")
	public ResponseEntity<Object> addAppointment(@RequestBody Appointment appointment) {
		Appointment resUser = this.service.addAppointment(appointment);
		if (resUser == null) {
			return new ResponseEntity<Object>("Appointment not add Sucessfully", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Object>(resUser, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<Object> getAllAppointments() {
		List<Appointment> appointments = this.service.getAppointment();
		return new ResponseEntity<Object>(appointments, HttpStatus.OK);
	}

	@GetMapping("/{appointmentId}")
	public ResponseEntity<Object> getAppointmentById(@PathVariable int patientId) {
		Appointment resUser = this.service.getAppointmentById(patientId);
		if (resUser == null) {
			return new ResponseEntity<Object>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(resUser, HttpStatus.OK);
	}

	@PatchMapping("/appointmentDate")
	public ResponseEntity<Object> updateAppointmentDate(@RequestBody Map<String, Object> body) {
		Appointment resUser = this.service.updateAppointment((Integer) body.get("appointmentId"), body.get("appointmentDate").toString());

		if (resUser == null) {
			return new ResponseEntity<Object>("appointmentDate updation failed", HttpStatus.NOT_ACCEPTABLE);
		}

		return new ResponseEntity<Object>("appointmentDate updated sucessfully", HttpStatus.OK);
	}
	
	@PatchMapping("/appointmentTime")
	public ResponseEntity<Object> updateAppointmentTime(@RequestBody Map<String, Object> body) {
		Appointment resUser = this.service.updateAppointment((Integer) body.get("appointmentId"), body.get("appointmentTime").toString());

		if (resUser == null) {
			return new ResponseEntity<Object>("appointmentTime updation failed", HttpStatus.NOT_ACCEPTABLE);
		}

		return new ResponseEntity<Object>("appointmentTime updated sucessfully", HttpStatus.OK);
	}

	@PostMapping("/udateAppointment")
	public ResponseEntity<Object> udateAppointment(@RequestBody Appointment appointment) {
		Appointment resUser = this.service.updateAppointment(appointment);
		if (resUser == null) {
			return new ResponseEntity<Object>("Appointment not add Sucessfully", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Object>(resUser, HttpStatus.CREATED);
	}

	@DeleteMapping("/{appointmentId}")
	public ResponseEntity<Object> removeUser(@PathVariable int appointmentId) {
		String res = this.service.deleteUser(appointmentId);
		if (res == null) {
			return new ResponseEntity<Object>("appointment not deleted !", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
}
