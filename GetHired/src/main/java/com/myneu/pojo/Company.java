package com.myneu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="userid")
public class Company extends UserAccount{

	
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "location")
	private String location;
	
	
	public Company(String emailID, String password, String confirmPassword, String companyName, String location) {
		super(emailID, password, confirmPassword);
		this.companyName = companyName;
		this.location = location;
	}
	
	public Company(){
		
		
	}
	

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Job> job = new HashSet<Job>();
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Job> getJob() {
		return job;
	}

	public void setJob(Set<Job> job) {
		this.job = job;
	}
	
    public void addJob(Job job) {
        getJob().add(job);
    }


	
	
}
