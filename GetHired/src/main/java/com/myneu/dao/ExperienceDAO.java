package com.myneu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myneu.pojo.Candidate;
import com.myneu.pojo.Education;
import com.myneu.pojo.ProfessionalEx;
import com.yusuf.spring.exception.AdException;
@Repository
public class ExperienceDAO extends DAO{
	public ExperienceDAO(){	
	}
	
	 public ProfessionalEx createexperience(String companyName, String startDate, String endDate, String designation, String responsibilities, String candiateEmail, Candidate c)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	            ProfessionalEx professionalEx=new ProfessionalEx();
	            professionalEx.setCompanyName(companyName);
	            professionalEx.setStartDate(startDate);
	            professionalEx.setEndDate(endDate);
	            professionalEx.setDesignation(designation);
	            professionalEx.setResponsibilities(responsibilities);
	            professionalEx.setCandidateEmail(candiateEmail);
	            professionalEx.setCandidate(c);
	            
	            getSession().save(professionalEx);
	            
	            commit();
	            return professionalEx;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create experience" + emailId, e);
	            throw new AdException("Exception while creating experience: " + e.getMessage());
	        }
	    }
	 
	 public List listExperience(String candidateEmail) throws AdException {
	        try {
	            begin();
	            System.out.println("ooooooooooooiiii" +candidateEmail);
	            Query q = getSession().createQuery("from ProfessionalEx where candidateEmail = :candidateEmail");
	            q.setString("candidateEmail", candidateEmail);
	            System.out.println("yuuuuuuuuyuyuyu" +q);
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
