package com.myneu.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProfessionalEx {
	
		@Id @GeneratedValue
		@Column(name="id", unique = true, nullable = false)
		private long id;
		private String companyName;
		private String startDate;
		private String endDate;
		private String designation;
		private String responsibilities;
		
			
		@ManyToOne
		@JoinColumn(name="userid")
		private Candidate candidate;
		private String candidateEmail;
		
		public ProfessionalEx(){
			
			
		}
		

		

		public String getCandidateEmail() {
			return candidateEmail;
		}


		public void setCandidateEmail(String candidateEmail) {
			this.candidateEmail = candidateEmail;
		}


		public long getId() {
			return id;
		}
		
		public void setId(long id) {
			this.id = id;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
//		public Date getStartDate() {
//			return startDate;
//		}
//		public void setStartDate(Date startDate) {
//			this.startDate = startDate;
//		}
//		public Date getEndDate() {
//			return endDate;
//		}
//		public void setEndDate(Date endDate) {
//			this.endDate = endDate;
//		}
		
		
		public String getDesignation() {
			return designation;
		}
		public String getStartDate() {
			return startDate;
		}


		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}


		public String getEndDate() {
			return endDate;
		}


		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}


		public Candidate getCandidate() {
			return candidate;
		}


		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}


		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getResponsibilities() {
			return responsibilities;
		}
		public void setResponsibilities(String responsibilities) {
			this.responsibilities = responsibilities;
		}
		
		
		
}
