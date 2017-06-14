package com.myneu.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myneu.pojo.Candidate;
import com.myneu.pojo.Education;
import com.myneu.pojo.Job;
import com.myneu.pojo.WorkRequestC2E;
import com.yusuf.spring.exception.AdException;
@Repository
public class EducationDAO extends DAO{
	
	
	public EducationDAO(){	
	}
	
	 public Education createeducation(String degreeName, String attendedFrom, String attendedTo, String major, String schoolName, String candiateEmail, Candidate c)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	            Education education=new Education();
	            education.setSchoolName(schoolName);
	            education.setDegreeName(degreeName);
	            education.setMajor(major);
	            education.setAttendedFrom(attendedFrom);
	            education.setAttendedTo(attendedTo);
	            education.setCandidateEmail(candiateEmail);
	            education.setCandidate(c);
	          
	            
	            getSession().save(education);
	            
	            commit();
	            return education;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create education" + emailId, e);
	            throw new AdException("Exception while creating education: " + e.getMessage());
	        }
	    }
	 
	 
	    public List listEducation(String candidateEmail) throws AdException {
	        try {
	            begin();
	            System.out.println("aaaaaaaaaaa" +candidateEmail);
	            Query q = getSession().createQuery("from Education where candidateEmail = :candidateEmail");
	            q.setString("candidateEmail", candidateEmail);
	            System.out.println("ssssssssssssss" +q);
	            List list = q.list();
	            System.out.println("in DAO Array Size" +list.size());
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            System.out.println(e.getMessage());
	            throw new AdException("Could not list the eduation details", e);
	    
	        }
	    }

}
