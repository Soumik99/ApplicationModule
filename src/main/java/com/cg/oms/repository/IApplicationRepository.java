package com.cg.oms.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.oms.entity.Application;

@Repository
@Transactional
public interface IApplicationRepository extends JpaRepository<Application, Integer> {
		
		//Custom methods
		
		//Get application details by email_id
		@Query("select a from Application a where a.emailId =?1")
		ArrayList<Application> findByEmail(String email);
		
		//Get application details by application_status
		@Query("select a from Application a where a.applicationStatus =?1")
		ArrayList<Application> findByStatus(String status);
				
		//Delete application by email_id
		//@Transactional
		@Modifying
		@Query("delete from Application a where a.emailId =:emailId")
		int deleteApplicationByEmailId(@Param("emailId") String emailId);	
		
		//Delete application by application_id
		
		@Modifying
		@Query("delete from Application a where a.applicationId =:applicationId")
		int deleteById(@Param("applicationId") int applicationId);
		
		//Application deleteByApplicationId(int applicationId);
		
}
