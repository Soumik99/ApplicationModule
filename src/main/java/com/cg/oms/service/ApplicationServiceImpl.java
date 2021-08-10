package com.cg.oms.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.entity.Application;
import com.cg.oms.exception.ApplicationFoundException;
import com.cg.oms.exception.ApplicationNotFoundException;
import com.cg.oms.repository.IApplicationRepository;

@Service
public class ApplicationServiceImpl implements IApplicationService{
	
	@Autowired
	IApplicationRepository appRepo;
	
	//Add new application
	@Override
	public Application addApplication(Application application) {
		Optional<Application> opt = appRepo.findById(application.getApplicationId());
		if(opt.isPresent()) {
			throw new ApplicationFoundException("Application already exist with given id:"+application.getApplicationId());
		}
		else return appRepo.save(application);
	}
	
	//Get all applications
	@Override
	public ArrayList<Application> viewAllApplicationDetails() {
		return (ArrayList<Application>)appRepo.findAll();
	}
	
	//Get application by id
		@Override
		public Application getApplicationById(int applicationId) {
			Optional<Application> opt = appRepo.findById(applicationId);
			if(!opt.isPresent()) {
				throw new ApplicationNotFoundException("Application not found with given id:"+applicationId);
			}
			return opt.get() ;
		}
		
	//Get applications by email_id
	@Override
	public ArrayList<Application> getApplicationDetailsByEmail(String email) {
		ArrayList<Application> app = appRepo.findByEmail(email);
		if(app.isEmpty()) {
			throw new ApplicationNotFoundException("Application not found with given email:"+email);
		}
		return app;
	}
	
	//Get applications by application_status
	@Override
	public ArrayList<Application> getApplicationDetailsByStatus(String status) {
		ArrayList<Application> app = appRepo.findByStatus(status);
		if(app.isEmpty()) {
			throw new ApplicationNotFoundException("Application not found with given status :"+status);
		}
		return app;
	}
	
	//Delete application by id
	@Override
	public int deleteApplicationById(int applicationId) {
		//Find Application
		Optional<Application> opt = appRepo.findById(applicationId);
		//If application present then delete
		if(!opt.isPresent()) {
			throw new ApplicationNotFoundException("Application not found with given id:"+applicationId);
		}
		else return appRepo.deleteById(applicationId);
	}
	
	//Delete application by email_id
	@Override
	public int deleteApplicationByEmailId(String emailId) {
		ArrayList<Application> app = appRepo.findByEmail(emailId);
		if(app.isEmpty()) {
			throw new ApplicationNotFoundException("Application not found with given email:"+emailId);
		}
		else return appRepo.deleteApplicationByEmailId(emailId);
	}
	
	
	
	//Update application application_status
	@Override
	public Application updateApplicationStatus(Application application) {
		//Find application
		Optional<Application> opt = appRepo.findById(application.getApplicationId());
		//Update application details
		if(opt.isPresent()) {
			Application dbApp = opt.get();
			dbApp.setApplicantFullName(application.getApplicantFullName());
			dbApp.setApplicantInterviewFeedback(application.getApplicantInterviewFeedback());
			dbApp.setApplicationStatus(application.getApplicationStatus());
			dbApp.setDateOfBirth(application.getDateOfBirth());
			dbApp.setDateOfInterview(application.getDateOfInterview());
			dbApp.setEmailId(application.getEmailId());
			dbApp.setFinalYearPercentage(application.getFinalYearPercentage());
			dbApp.setGoals(application.getGoals());
			dbApp.setHighestQualification(application.getHighestQualification());
			//save
			appRepo.save(dbApp);
			return application ;
			
		}
		else throw new ApplicationNotFoundException("Application not found with given id:"+application.getApplicationId());
		
	}

}
