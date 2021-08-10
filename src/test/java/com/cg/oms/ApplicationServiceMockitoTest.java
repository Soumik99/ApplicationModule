package com.cg.oms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.oms.entity.Application;
import com.cg.oms.entity.ProgramScheduled;
import com.cg.oms.repository.IApplicationRepository;
import com.cg.oms.service.ApplicationServiceImpl;

@SuppressWarnings("unused")
@ExtendWith(SpringExtension.class)
class ApplicationServiceMockitoTest {
	
	/* @InjectMock - injects ApplicationServiceImpl and inject dependent classes/interfaces
	  that are annotated with @Mock */
	@InjectMocks
	ApplicationServiceImpl appServ;
	
	// @MockBean - injecting external services
	@MockBean
	IApplicationRepository appRepo;
	
	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	//testing addApplication
	@Test
	void testAddApplication() {
		ProgramScheduled schedule1 = new ProgramScheduled(5001);
		LocalDate dob = LocalDate.parse("1999-07-25");
		LocalDate doi = LocalDate.parse("2021-08-10");
		Application application1 = new Application(1005,"Tom Smith", dob,"B.Tech", 90.5, "Researcher",schedule1, "abc@email.com","ScheduleForInterview",doi,"ToBeGiven");
	
		Mockito.when(appRepo.save(application1)).thenReturn(application1);
		Application response = appServ.addApplication(application1);
		
		assertEquals(1005, response.getApplicationId());
		assertEquals(90.5, response.getFinalYearPercentage());
		assertEquals(5001, response.getSchedule().getScheduleId());
	}
	
	//testing viewAllApplicationDetails
	@Test
	void testViewAllApplication() {
		ProgramScheduled schedule1 = new ProgramScheduled(5001);
		LocalDate dob = LocalDate.parse("1999-07-25");
		LocalDate doi = LocalDate.parse("2021-08-10");
		Application application1 = new Application(1005,"Tom Smith", dob,"B.Tech", 90.5, "Researcher",schedule1, "abc@email.com","ScheduleForInterview",doi,"ToBeGiven");
		
		ArrayList<Application> appList = new ArrayList<Application>();
		appList.add(application1);
		
		Mockito.when(appRepo.findAll()).thenReturn(appList);
		ArrayList<Application> response = appServ.viewAllApplicationDetails();
		
		assertEquals(1,response.size());
		assertEquals("Tom Smith", response.get(0).getApplicantFullName());

	}
	
	//testing getApplicationById
	@Test
	void testGetApplicationById() {
		ProgramScheduled schedule1 = new ProgramScheduled(5001);
		LocalDate dob = LocalDate.parse("1999-07-25");
		LocalDate doi = LocalDate.parse("2021-08-10");
		Application application1 = new Application(1005,"Tom Smith", dob,"B.Tech", 90.5, "Researcher",schedule1, "abc@email.com","ScheduleForInterview",doi,"ToBeGiven");
			
			
		Mockito.when(appRepo.findById(1005)).thenReturn(Optional.of(application1));
		Application response = appServ.getApplicationById(1005);
			
		assertEquals("Tom Smith", response.getApplicantFullName());
		assertEquals("abc@email.com",response.getEmailId());
	}
	
	
	//testing  getApplicationDetailsByEmail
	@Test
	void testGetApplicationDetailsByEmail() {
		ProgramScheduled schedule1 = new ProgramScheduled(5001);
		LocalDate dob = LocalDate.parse("1999-07-25");
		LocalDate doi = LocalDate.parse("2021-08-10");
		Application application1 = new Application(1005,"Tom Smith", dob,"B.Tech", 90.5, "Researcher",schedule1, "abc@email.com","ScheduleForInterview",doi,"ToBeGiven");
			
		ArrayList<Application> appList = new ArrayList<Application>();
		appList.add(application1);
			
		Mockito.when(appRepo.findByEmail("abc@email.com")).thenReturn(appList);
		ArrayList<Application> response = appServ.getApplicationDetailsByEmail("abc@email.com");
	
		assertEquals(1,response.size());
		assertEquals("Tom Smith", response.get(0).getApplicantFullName());
	}
	
	//testing getApplicationDetailsByStatus
	@Test
	void testGetApplicationDetailsByStatus() {
		ProgramScheduled schedule1 = new ProgramScheduled(5001);
		LocalDate dob = LocalDate.parse("1999-07-25");
		LocalDate doi = LocalDate.parse("2021-08-10");
		Application application1 = new Application(1005,"Tom Smith", dob,"B.Tech", 90.5, "Researcher",schedule1, "abc@email.com","ScheduleForInterview",doi,"ToBeGiven");
		
		ArrayList<Application> appList = new ArrayList<Application>();
		appList.add(application1);
		
		Mockito.when(appRepo.findByStatus("ScheduleForInterview")).thenReturn(appList);
		ArrayList<Application> response = appServ.getApplicationDetailsByStatus("ScheduleForInterview");
		assertEquals(1,response.size());
	}
	
	//testing deleteApplicationById
	@Test
	void testDeleteApplicationById() {
		ProgramScheduled schedule1 = new ProgramScheduled(5001);
		LocalDate dob = LocalDate.parse("1999-07-25");
		LocalDate doi = LocalDate.parse("2021-08-10");
		Application application1 = new Application(1005,"Tom Smith", dob,"B.Tech", 90.5, "Researcher",schedule1, "abc@email.com","ScheduleForInterview",doi,"ToBeGiven");
			
		Mockito.when(appRepo.findById(1005)).thenReturn(Optional.of(application1));
		Mockito.when(appRepo.deleteById(1005)).thenReturn(1005);
		int response = appServ.deleteApplicationById(1005);
		assertEquals(1005,response);
	}
		
	//testing deleteApplicationByEmailId
	@Test
	void testDeleteApplicationByEmailId() {
		ProgramScheduled schedule1 = new ProgramScheduled(5001);
		LocalDate dob = LocalDate.parse("1999-07-25");
		LocalDate doi = LocalDate.parse("2021-08-10");
		Application application1 = new Application(1005,"Tom Smith", dob,"B.Tech", 90.5, "Researcher",schedule1, "abc@email.com","ScheduleForInterview",doi,"ToBeGiven");
		ArrayList<Application> appList = new ArrayList<Application>();
		appList.add(application1);
			
		Mockito.when(appRepo.findByEmail("abc@email.com")).thenReturn(appList);
		Mockito.when(appRepo.deleteApplicationByEmailId("abc@email.com")).thenReturn(1005);
		int response = appServ.deleteApplicationByEmailId("abc@email.com");
		assertEquals(1005,response);
	}
	
	//testing updateApplicationStatus
	@Test
	void testUpdateApplicationStatus() {
		ProgramScheduled schedule1 = new ProgramScheduled(5001);
		LocalDate dob = LocalDate.parse("1999-07-25");
		LocalDate doi = LocalDate.parse("2021-08-10");
		Application application1 = new Application(1005,"Tom Smith", dob,"B.Tech", 90.5, "Researcher",schedule1, "abc@email.com","ScheduleForInterview",doi,"ToBeGiven");
			
		Mockito.when(appRepo.findById(1005)).thenReturn(Optional.of(application1));
		Mockito.when(appRepo.save(application1)).thenReturn(application1);
			
		Application response = appServ.updateApplicationStatus(application1);
			
		assertEquals("Tom Smith", response.getApplicantFullName());
		assertEquals("abc@email.com",response.getEmailId());
		assertEquals(90.5, response.getFinalYearPercentage());
		assertEquals(5001, response.getSchedule().getScheduleId());
	}
		
	
}
