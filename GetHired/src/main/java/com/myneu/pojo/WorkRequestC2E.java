package com.myneu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WorkRequestC2E {
	
	
	@Id @GeneratedValue
	@Column(name="workRequestID", unique = true, nullable = false)
	private long workRequestID;
	
	
	
	public long getWorkRequestID() {
		return workRequestID;
	}



	public void setWorkRequestID(long workRequestID) {
		this.workRequestID = workRequestID;
	}

	private String companyName;
	private int jobID;


	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public int getJobID() {
		return jobID;
	}



	public void setJobID(int jobID) {
		this.jobID = jobID;
	}



	public Candidate getCandidate() {
		return candidate;
	}



	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	@ManyToOne
	@JoinColumn(name="userid")
	private Candidate candidate;
	
	
	private String sender;
	private String receiver;
	private String status;
	

	
	public WorkRequestC2E(){
		
		
	}
	
	
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
