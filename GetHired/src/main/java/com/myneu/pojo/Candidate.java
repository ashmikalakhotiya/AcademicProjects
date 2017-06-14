package com.myneu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="candidate")
@PrimaryKeyJoinColumn(name="userid")
public class Candidate extends UserAccount {

	//private long candidateID;
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	
	
	@Lob
	@Column(name="cand_resume",columnDefinition="mediumblob")
	private byte[] resume;
	
	
	@Column(name="resumeName")
	private String resumeName;
	public String getResumeName() {
		return resumeName;
	}
	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
	public Candidate(){
		
		
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<WorkRequestC2E> workRequestC2E = new HashSet<WorkRequestC2E>();
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Education> education = new HashSet<Education>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<ProfessionalEx> professionalEx = new HashSet<ProfessionalEx>();
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public Candidate(String emailID, String password, String confirmPassword, String firstName, String lastName, 
			String resumeName, byte[] resume, String phone) {
	super(emailID, password, confirmPassword);
	this.firstName = firstName;
	this.lastName = lastName;
	this.resume = resume;
	this.resumeName = resumeName;
	this.phone = phone;
}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<WorkRequestC2E> getWorkRequestC2E() {
		return workRequestC2E;
	}
	public void setWorkRequestC2E(Set<WorkRequestC2E> workRequestC2E) {
		this.workRequestC2E = workRequestC2E;
	}
	

    public void addWorkRequestC2E(WorkRequestC2E workRequestC2E) {
        getWorkRequestC2E().add(workRequestC2E);
    }
	public Set<Education> getEducation() {
		return education;
	}
	public void setEducation(Set<Education> education) {
		this.education = education;
	}
	public Set<ProfessionalEx> getProfessionalEx() {
		return professionalEx;
	}
	public void setProfessionalEx(Set<ProfessionalEx> professionalEx) {
		this.professionalEx = professionalEx;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
//	public String getCitizenship() {
//		return citizenship;
//	}
//	public void setCitizenship(String citizenship) {
//		this.citizenship = citizenship;
//	}    
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
