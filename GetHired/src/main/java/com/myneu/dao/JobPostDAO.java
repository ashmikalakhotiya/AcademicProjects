package com.myneu.dao;



import java.util.Date;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.validation.ValidationUtils;

import com.myneu.pojo.Company;
import com.myneu.pojo.Job;
import com.yusuf.spring.exception.AdException;
@Repository
public class JobPostDAO extends DAO {
	
	public JobPostDAO(){	
	}
	
	 public Job createjob(String jobTitle, String jobDescription, String jobType, int experience, String skills, String qualification, String location, String postedOn, String postedBy, String industry, Company c, String companyName)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	            Job job=new Job();
	           //Company cmp =  new Company();
	            
	            job.setJobTitle(jobTitle);
	            job.setJobDescription(jobDescription);
	            job.setJobType(jobType);
	            job.setExperience(experience);
	            job.setSkills(skills);
	            job.setQualification(qualification);
	            job.setLocation(location);
	            job.setPostedOn(postedOn);
	            job.setPostedBy(postedBy);
	            job.setIndustry(industry);
	            job.setCompany(c);
	            job.setCompanyName(companyName);
	            
	            getSession().save(job);
	            
	            commit();
	            return job;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create job " + emailId, e);
	            throw new AdException("Exception while creating job: " + e.getMessage());
	        }
	    }

}
