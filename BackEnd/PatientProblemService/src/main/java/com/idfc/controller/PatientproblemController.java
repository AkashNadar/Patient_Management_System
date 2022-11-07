package com.idfc.controller;

import java.util.List;
import java.util.Map;

import com.idfc.model.Patient;
import com.idfc.service.PatientProblemServiceImpl;

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
@RequestMapping("/patient")
public class PatientproblemController {

	@Autowired
	private PatientProblemServiceImpl service;
	
	@PostMapping("/addPatient")
	public ResponseEntity<Object> addUser(@RequestBody Patient patient){
		Patient resUser = this.service.addPatient(patient);
		if(resUser == null) {
			return new ResponseEntity<Object>("User not add Sucessfully", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Object>(resUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getAllUsers(){
		List<Patient> patients = this.service.getPatient();
		return new ResponseEntity<Object>(patients, HttpStatus.OK);
	}
	
	@GetMapping("/{patientId}")
	public ResponseEntity<Object> getUserById(@PathVariable int patientId){
		Patient resUser = this.service.getProblemById(patientId);
		if(resUser == null) {
			return new ResponseEntity<Object>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(resUser, HttpStatus.OK);
	}
	
	@PatchMapping("/patientId")
	public ResponseEntity<Object> updatePassword(@RequestBody Map<String, Object> body){
		Patient resUser = this.service.updatePatient(
				(Integer)body.get("problemId"), 
				body.get("patientId").toString());
		
		if(resUser == null) {
			return new ResponseEntity<Object>("patientId updation failed", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<Object>("patientId updated sucessfully", HttpStatus.OK);
	}
	
	@PatchMapping("/sympoms")
	public ResponseEntity<Object> updateSympoms(@RequestBody Map<String, Object> body){
		Patient resUser = this.service.updatePatient(
				(Integer)body.get("problemId"), 
				body.get("sympoms").toString());
		
		if(resUser == null) {
			return new ResponseEntity<Object>("sympoms updation failed", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<Object>("sympoms updated sucessfully", HttpStatus.OK);
	}
	
	@PostMapping("/udatePatient")
	public ResponseEntity<Object> udatePatient(@RequestBody Patient patient){
		Patient resUser = this.service.updatePatient(patient);
		if(resUser == null) {
			return new ResponseEntity<Object>("User not add Sucessfully", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Object>(resUser, HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{patientId}")
	public ResponseEntity<Object> removeUser(@PathVariable int patientId){
		String res = this.service.deleteUser(patientId);
		if(res == null) {
			return new ResponseEntity<Object>("patient not deleted !", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
}
