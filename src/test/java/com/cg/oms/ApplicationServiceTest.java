package com.cg.oms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oms.entity.Application;
import com.cg.oms.entity.ProgramScheduled;
import com.cg.oms.service.IApplicationService;

@SuppressWarnings("unused")
@SpringBootTest
class ApplicationServiceTest {
	
	@Autowired
	IApplicationService appServ;
	
	
	//testing viewAllApplicationDetails
	@Test
	void testViewAllApplication() {
		ArrayList<Application> application = appServ.viewAllApplicationDetails();
		assertEquals(2,application.size());
		assertEquals("Tom Smith", application.get(0).getApplicantFullName());
	}
	
	//testing  getApplicationDetailsByEmail
	@Test
	void testGetApplicationDetailsByEmail() {
		ArrayList<Application> application = appServ.getApplicationDetailsByEmail("abc@email.com");
		assertEquals(1, application.size());
		assertEquals("Tom Smith", application.get(0).getApplicantFullName());

	}
	
	//testing getApplicationById
	@Test
	void testGetApplicationById() {
		Application application = appServ.getApplicationById(1002);
		assertEquals("Tom Smith", application.getApplicantFullName());
		assertEquals("1999-07-25", application.getDateOfBirth().toString());
		assertEquals("B.Tech", application.getHighestQualification());
		assertEquals("abc@email.com", application.getEmailId());
	}
	
	//testing getApplicationDetailsByStatus
	@Test
	void testGetApplicationDetailsByStatus() {
		ArrayList<Application> application = appServ.getApplicationDetailsByStatus("ScheduleForInterview");
		assertEquals(1, application.size());
	}
	
	
	
	//testing deleteApplicationById
	@Test
	void testDeleteApplicationById() {
		int id = 1004;
		int count = appServ.deleteApplicationById(id);
		assertEquals(1,count);
	}
	
	//testing deleteApplicationByEmailId
	@Test
	void testDeleteApplicationByEmailId() {
		String email = "def@email.com";
		int count = appServ.deleteApplicationByEmailId(email);
		assertEquals(1,count);
	}
	
	//testing addApplication
	@Test
	void testAddApplication() {
		ProgramScheduled schedule1 = new ProgramScheduled(2002);
		LocalDate dob = LocalDate.parse("1998-01-12");
		LocalDate doi = LocalDate.parse("2021-07-6");
		Application application = new Application(1004,"Jason Paul", dob,"B.Sc", 95.6, "Scinetist",schedule1, "def@email.com","InterViewCompleted",doi,"Accepted");
		Application persistedApp = appServ.addApplication(application);
		
		assertEquals(1003, persistedApp.getApplicationId());
		assertEquals(90.5, persistedApp.getFinalYearPercentage());
	}
	//testing updateApplicationStatus
	@Test
	void testUpdateApplicationStatus() {
		
		ProgramScheduled schedule1 = new ProgramScheduled(2001);
		LocalDate dob = LocalDate.parse("1999-07-25");
		LocalDate doi = LocalDate.parse("2021-08-10");
		Application application = new Application(1002,"Tom Smith", dob,"B.Tech", 90.5, "Researcher",schedule1, "abc@email.com","ScheduleForInterview",doi,"ToBeGiven");
		Application persistedApp = appServ.updateApplicationStatus(application);
		
		assertEquals(1002, persistedApp.getApplicationId());
		assertEquals(90.5, persistedApp.getFinalYearPercentage());
	}
	
}
