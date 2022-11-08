package com.dk.controller;

import java.util.List;
import java.util.Map;

import com.dk.model.Diagnosis;
import com.dk.service.diagService;
//import com.dk.service.diagServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosis")
public class diagController {

	@Autowired
	private diagService service;
	
	@PostMapping("/")
	public ResponseEntity<Object> addDiagnosis(@RequestBody Diagnosis diagnosis){
		Diagnosis res = service.addDiagnosis(diagnosis);
		if(res == null) {
			return new ResponseEntity<Object>("Diagnosis not added", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(res, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getAllDiagnosis(){
		List<Diagnosis> diagnosis = this.service.getDiagnosis();
		return new ResponseEntity<Object>(diagnosis, HttpStatus.OK);
	}
	
	@GetMapping("/{diagId}")
	public ResponseEntity<Object> getDiagnosisById(@PathVariable int diagId){
		Diagnosis res = this.service.getDiagnosisById(diagId).get();
		if(res == null) {
			return new ResponseEntity<Object>("Diagnosis not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
	
	@DeleteMapping("/{diagId}")
	public ResponseEntity<Object> deleteDiagnosis(@PathVariable int diagId){
		String res = this.service.deleteDiagnosis(diagId);
		if(res == null) {
			return new ResponseEntity<Object>("Diagnosis not deleted !", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
	
	//to be Modified
	@PutMapping("/")
	public ResponseEntity<Object> updateDiagnosis(@RequestBody Map<String, Object> body){
		Diagnosis res = this.service.updateDiagnosis(
				(Integer)body.get("diagId"),
				body.get("diagnosis").toString());
		if(res == null) {
			return new ResponseEntity<Object>("Diagnosis not updated", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Object>("Diagnosis updated", HttpStatus.OK);
	}

}
	
	
	