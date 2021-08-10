package com.cg.oms.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oms.entity.Application;
import com.cg.oms.service.IApplicationService;

@RestController
public class ApplicationController {
	
	@Autowired
	IApplicationService appServ;
	
	//Add application - POST
	@PostMapping("/application")
	public ResponseEntity<Application> addApplication(@Valid @RequestBody Application application) {
		return new ResponseEntity<> (appServ.addApplication(application),HttpStatus.CREATED);
	}
	
	//Getting all applications - GET
	@GetMapping("/application/all")
	public ResponseEntity<ArrayList<Application>> viewAllApplicationDetails(){
		return new ResponseEntity<> (appServ.viewAllApplicationDetails(),HttpStatus.OK);
	}
	
	//Getting applications by email_id - GET
	@GetMapping("/application/byEmail/{emailId}")
	public ResponseEntity<ArrayList<Application>> getApplicationDetailsByEmail(@PathVariable("emailId")String email){
		return new ResponseEntity<> (appServ.getApplicationDetailsByEmail(email),HttpStatus.OK);
	}
	
	//Getting applications by application_status - GET
	@GetMapping("/application/byStatus/{applicationStatus}")
	public  ResponseEntity<ArrayList<Application>> getApplicationDetailsByStatus(@PathVariable("applicationStatus") String status){
		return new ResponseEntity<> (appServ.getApplicationDetailsByStatus(status),HttpStatus.OK);
	}
	
	//Getting application by Id - GET
	@GetMapping("/application/byId/{applicationId}")
	public ResponseEntity<Application> getApplicationById(@PathVariable("applicationId") int applicationId) {
		return new ResponseEntity<> (appServ.getApplicationById(applicationId),HttpStatus.OK);
	}
	
	//Delete application by Id - DELETE
	@DeleteMapping("/application/byId/{applicationId}")
	public ResponseEntity<Integer> deleteApplicationById(@PathVariable("applicationId") int applicationId) { 
		return new ResponseEntity<> (appServ.deleteApplicationById(applicationId),HttpStatus.ACCEPTED);
	}
	
	//Delete application by email_id - DELETE
	@DeleteMapping("/application/byEmail/{emailId}")
	public ResponseEntity<Integer> deleteApplicationByEmail(@PathVariable("emailId") String emailId) {
		return new ResponseEntity<> (appServ.deleteApplicationByEmailId(emailId),HttpStatus.ACCEPTED);
	}
	
	//Update application details - PUT
	@PutMapping("/application/update")
	public ResponseEntity<Application > updateApplicationStatus(@Valid @RequestBody Application application) {
		return new ResponseEntity<> (appServ.updateApplicationStatus(application),HttpStatus.ACCEPTED);
	}
		
}
