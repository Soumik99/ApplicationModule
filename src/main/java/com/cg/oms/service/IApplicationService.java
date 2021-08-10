package com.cg.oms.service;

import java.util.ArrayList;

import com.cg.oms.entity.Application;



public interface IApplicationService {
	//Add new application
	public Application addApplication(Application application);
	//Get all applications
	public ArrayList<Application> viewAllApplicationDetails();
	//Get applications by email_id
	public  ArrayList<Application> getApplicationDetailsByEmail(String email);
	//Get applications by application_status
	public  ArrayList<Application> getApplicationDetailsByStatus(String status);
	//Delete application by id
	public int deleteApplicationById(int applicationId);
	//Delete application by email_id
	public int deleteApplicationByEmailId(String emailId);
	//Get application by id
	public Application getApplicationById(int applicationId);
	//Update application application_status
	public Application  updateApplicationStatus(Application application);
	
}
