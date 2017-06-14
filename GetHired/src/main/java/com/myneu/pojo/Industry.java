package com.myneu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="industry")

public class Industry {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="industryid", unique = true, nullable = false)
	private long industryid;
	
	@Column(name="industryType")
	private String industryType;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="industry")
	private Set<Job> jobs = new HashSet<Job>();

	public Industry(String industryType) {
		super();
		this.industryType = industryType;
		this.jobs = jobs;
	}

	public long getIndustryid() {
		return industryid;
	}

	public void setIndustryid(long industryid) {
		this.industryid = industryid;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	
	
	
}
