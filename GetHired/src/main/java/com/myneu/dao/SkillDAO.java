package com.myneu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myneu.pojo.Candidate;
import com.myneu.pojo.Education;
import com.myneu.pojo.Skill;
import com.yusuf.spring.exception.AdException;
@Repository
public class SkillDAO extends DAO{

	public SkillDAO(){
		
	}
	
	public Skill createskill(String skillname, String proficiency, String candiateEmail, Candidate candidate)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
         //   System.out.println("inside DAO" +candidate);
            
            Skill skill =  new Skill();
            skill.setSkillname(skillname);
            skill.setProficiency(proficiency);
            skill.setCandidateEmail(candiateEmail);
            skill.setCandidate(candidate);
            
//            Education education=new Education(degreeName, attendedFrom, attendedTo, major, schoolName, candiateEmail);
//            education.setSchoolName(schoolName);
//            education.setDegreeName(degreeName);
//            education.setMajor(major);
//            education.setAttendedFrom(attendedFrom);
//            education.setAttendedTo(attendedTo);
//            education.setCandidateEmail(candiateEmail);
          
            
            getSession().save(skill);
            
            commit();
            return skill;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create education" + emailId, e);
            throw new AdException("Exception while creating education: " + e.getMessage());
        }
    }
 
 
    public List listSkill(String candidateEmail) throws AdException {
        try {
            begin();
            System.out.println("skilllllllllllllllllllllllll" +candidateEmail);
            Query q = getSession().createQuery("from Skill where candidateEmail = :candidateEmail");
            q.setString("candidateEmail", candidateEmail);
            System.out.println("ssssssssssssss" +q);
            List list = q.list();
            System.out.println("in DAO Array Size" +list.size());
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println(e.getMessage());
            throw new AdException("Could not list the Skill details", e);
    
        }
    }

}
