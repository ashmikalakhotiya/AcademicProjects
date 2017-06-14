package com.myneu.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
public class Job {
	
	@Id @GeneratedValue
	@Column(name="jobID", unique = true, nullable = false)
	private int jobID;
	
	
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Company company;
	
	
	
	
	
	
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name="jobTitle")
	private String jobTitle;
	
	@Column(name="jobDescription")
	private String jobDescription;
	
	@Column(name="jobType")
	private String jobType;

	@Column(name = "experience")
	private int experience;
	
	@Column(name = "skills")
	private String skills;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "location")
	private String location;
	
//	@Column(name = "postedOn")
//	private Date postedOn;
	
	@Column(name = "postedOn")
	private String postedOn;

	
	
	@JoinColumn(name = "userID")
	private String postedBy;
	
	@Column(name = "industry")
	private String industry;
	
	public Job(){
		
		
	}
	@Column(name = "companyName")
	private String companyName;
	

	
	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


//	public Job(String jobTitle, String jobDescription, String jobType, int experience, String skills,
//			String qualification, String location, String postedOn, String postedBy, String industry) {
//		super();
//		this.jobTitle = jobTitle;
//		this.jobDescription = jobDescription;
//		this.jobType = jobType;
//		this.experience = experience;
//		this.skills = skills;
//		this.qualification = qualification;
//		this.location = location;
//		this.postedOn = postedOn;
//		this.postedBy = postedBy;
//		this.industry = industry;
//	}
//


	public String getPostedOn() {
		return postedOn;
	}


	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}


	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}



	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

//	public Date getPostedOn() {
//		return postedOn;
//	}
//
//	public void setPostedOn(Date postedOn) {
//		this.postedOn = postedOn;
//	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}		
	
}
