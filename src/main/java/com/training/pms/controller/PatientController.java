package com.training.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Patient;
import com.training.pms.service.PatientService;

@RestController
@RequestMapping("patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping()
	public ResponseEntity<List<Patient>> getPatients() {    //localhost:5050/patient   -GET
		List<Patient> result = patientService.getPatients();
		ResponseEntity<List<Patient>> responseEntity = null;
		if (result.size() == 0) {
			responseEntity = new ResponseEntity<List<Patient>>(result,HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<List<Patient>>(result,HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("{patientId}")
	public String getPatient(@PathVariable("patientId")int patientId) {    //localhost:5050/patient/1090   -GET
		return "Getting a single patient by patientId : "+patientId;
	}
	@PostMapping
	public String savePatient(@RequestBody Patient patient) {    //localhost:5050/patient  -POST
		return "Saving a single patient: "+patient;
	}
	@PutMapping("{patientId}")
	public String updatePatient(@PathVariable("patientId")int patientId,
			@RequestBody Patient patient) {    //localhost:5050/patient/1090  -PUT
		return "Updating a single patient with "+patientId+ " and the changes are: "+patient;
	}
	@DeleteMapping("{patientId}")
	public String deletePatient(@PathVariable("patientId")int patientId) {    //localhost:5050/patient/1090  -DELETE
		return "Deleting a single patient by patienttId: "+patientId;
	}
	@GetMapping("getPatientsByBillAmount/{lowerAmount}/{upperAmount}")
	public String getPatientsByBillAmount(@PathVariable("lowerAmount")int lowerAmount, @PathVariable("upperAmount")int upperAmount) {    //localhost:5050/patients/getPatientsByBillAmount/199/to/400
		return "Returning all the patients by bill amount between : "+lowerAmount+ " and "+upperAmount;
	}
	
}