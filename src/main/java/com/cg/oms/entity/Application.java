package com.cg.oms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="application")
public class Application {
		
	    //id should not be null
		//id should be a positive number
		@Id
		@NotNull(message = "Please enter id")
		@Positive(message = "id should be a positive number")
		private Integer applicationId;
		
		//name should not be null or empty
		//name should have at least 3 characters
		@NotEmpty(message = "Please enter name")
		@Size(min = 3, message = "Name should have at least 3 characters")
		@Column(name="full_name")
		private String applicantFullName;
		
		//date of birth should not be null
		//date of birth should be in the past
		//date of birth should be in YYYY-MM-DD format
		@NotNull(message = "Please enter date of birth")
		@Past
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name="date_of_birth")
		private LocalDate dateOfBirth;
		
		//qualification should not be null or empty
		//qualification should have at least 2 characters
		@NotEmpty(message = "Please enter highest qualification")
		@Size(min = 2, message = "Highest Qualification should have at least 2 characters")
		@Column(name="highest_qualfication")
		private String highestQualification;
		
		//final year percentage should not be null
		//final year percentage should be positive 
		@NotNull(message = "Please enter final year percentage")
		@Positive
		@Column(name="final_year_percentage")
		private double finalYearPercentage;
		
		//goals should not be null or empty
		//goals should have at least 3 characters
		@NotEmpty(message = "Please enter goals")
		@Size(min = 3, message = "Goals should have at least 3 characters")
		@Column(name="goals")
		private String goals;
		
		//email should not be null or empty
		//email should be a valid format
		@NotEmpty
		@Email(message = "email should be in valid format")
		@Column(name="email")
		private String emailId;
		
		//Many to one relationship between table Application and Program_scheduled  
		@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
		@JoinColumn(name="schedule_fk")
		private ProgramScheduled schedule;
		
		//application status should not be null or empty
		//application status should have at least 7 characters
		@NotEmpty(message = "Please enter application status")
		@Size(min = 7, message = "Application status should have at least 7 characters")
		@Column(name="status")
		private String applicationStatus;//Applied/ScheduleForInterview/InterViewCompleted/ApplicationAccepted/ApplicationRejected
		
		//date of interview should not be null or empty
		//date of interview should be in YYYY-MM-DD format
		@NotNull(message = "Please enter date of interview")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name="interview_date")
		private LocalDate dateOfInterview;
		
		//interview feedback should not be null or empty
		//feedback should have at least 3 characters
		@NotEmpty(message = "Please enter interview feedback")
		@Size(min = 3, message = "Feedback should have at least 3 characters")
		@Column(name="interview_feedback")
		private String applicantInterviewFeedback;
		
		//Getters & Setters
		public Integer getApplicationId() {
			return applicationId;
		}
		public void setApplicationId(Integer applicationId) {
			this.applicationId = applicationId;
		}
		public String getApplicantFullName() {
			return applicantFullName;
		}
		public void setApplicantFullName(String applicantFullName) {
			this.applicantFullName = applicantFullName;
		}
		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getHighestQualification() {
			return highestQualification;
		}
		public void setHighestQualification(String highestQualification) {
			this.highestQualification = highestQualification;
		}
		public double getFinalYearPercentage() {
			return finalYearPercentage;
		}
		public void setFinalYearPercentage(double finalYearPercentage) {
			this.finalYearPercentage = finalYearPercentage;
		}
		public String getGoals() {
			return goals;
		}
		public void setGoals(String goals) {
			this.goals = goals;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public ProgramScheduled getSchedule() {
			return schedule;
		}
		public void setSchedule(ProgramScheduled schedule) {
			this.schedule = schedule;
		}
		public String getApplicationStatus() {
			return applicationStatus;
		}
		public void setApplicationStatus(String applicationStatus) {
			this.applicationStatus = applicationStatus;
		}
		public LocalDate getDateOfInterview() {
			return dateOfInterview;
		}
		public void setDateOfInterview(LocalDate dateOfInterview) {
			this.dateOfInterview = dateOfInterview;
		}
		public String getApplicantInterviewFeedback() {
			return applicantInterviewFeedback;
		}
		public void setApplicantInterviewFeedback(String applicantInterviewFeedback) {
			this.applicantInterviewFeedback = applicantInterviewFeedback;
		}
		
		//Constructors
		public Application() {}
		
		public Application(Integer applicationId, String applicantFullName, LocalDate dateOfBirth,
				String highestQualification, double finalYearPercentage, String goals,ProgramScheduled schedule, String emailId,
				String applicationStatus, LocalDate dateOfInterview,
				String applicantInterviewFeedback) {
			super();
			this.applicationId = applicationId;
			this.applicantFullName = applicantFullName;
			this.dateOfBirth = dateOfBirth;
			this.highestQualification = highestQualification;
			this.finalYearPercentage = finalYearPercentage;
			this.goals = goals;
			this.emailId = emailId;
			this.schedule = schedule;
			this.applicationStatus = applicationStatus;
			this.dateOfInterview = dateOfInterview;
			this.applicantInterviewFeedback = applicantInterviewFeedback;
		}
		
		
		//Equals method
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Application other = (Application) obj;
			return applicationId == other.applicationId;
		}
		
		//toString method
		@Override
		public String toString() {
			return "Application [applicationId=" + applicationId + ", applicantFullName=" + applicantFullName
					+ ", dateOfBirth=" + dateOfBirth + ", highestQualification=" + highestQualification
					+ ", finalYearPercentage=" + finalYearPercentage + ", goals=" + goals + ", emailId=" + emailId
					+ ", applicationStatus=" + applicationStatus + ", dateOfInterview=" + dateOfInterview
					+ ", applicantInterviewFeedback=" + applicantInterviewFeedback + "]";
		}
		
		

}
