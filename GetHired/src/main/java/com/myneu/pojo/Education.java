package com.myneu.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Education {
	

	@Id @GeneratedValue
	@Column(name="id", unique = true, nullable = false)
	private long id;
	

	@ManyToOne
	@JoinColumn(name="userid")
	private Candidate candidate;

	
	private String candidateEmail;
	
	
	private String degreeName;
	private String schoolName;
	private String attendedFrom;
	private String attendedTo;
	private String major;
	public long getId() {
		return id;
	}
	
	public Education(){
		
		
	}
	
	
	
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public void setId(long id) {
		this.id = id;
	}
public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	//	public Date getAttendedFrom() {
//		return attendedFrom;
//	}
//	public void setAttendedFrom(Date attendedFrom) {
//		this.attendedFrom = attendedFrom;
//	}
//	public Date getAttendedTo() {
//		return attendedTo;
//	}
//	public void setAttendedTo(Date attendedTo) {
//		this.attendedTo = attendedTo;
//	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}


	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public String getAttendedFrom() {
		return attendedFrom;
	}
	public void setAttendedFrom(String attendedFrom) {
		this.attendedFrom = attendedFrom;
	}
	public String getAttendedTo() {
		return attendedTo;
	}
	public void setAttendedTo(String attendedTo) {
		this.attendedTo = attendedTo;
	}
	
	
	
	
}
