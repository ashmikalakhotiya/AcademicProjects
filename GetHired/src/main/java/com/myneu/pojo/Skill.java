package com.myneu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skill {


	
	@Id @GeneratedValue
	@Column(name="id", nullable = false)
	private long id;
	

	@ManyToOne
	@JoinColumn(name="userid")
	private Candidate candidate;
	
	private String candidateEmail;
	private String skillname;
	private String proficiency;
	
	public Skill(){
		
		
	}
	
	
//	public Skill(String skillname, String proficiency, String candidateEmail, Candidate candidate) {
//		super();
//		this.candidateEmail = candidateEmail;
//		this.skillname = skillname;
//		this.proficiency = proficiency;
//		this.candidate = candidate;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public String getProficiency() {
		return proficiency;
	}
	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}
	
	
	
	
	
	
	
}
