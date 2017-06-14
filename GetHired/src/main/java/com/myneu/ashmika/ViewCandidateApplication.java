package com.myneu.ashmika;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myneu.dao.CandidateDAO;
import com.myneu.dao.CompanyDAO;
import com.myneu.dao.EducationDAO;
import com.myneu.dao.ExperienceDAO;
import com.myneu.dao.LoginDAO;
import com.myneu.dao.SkillDAO;
import com.myneu.pojo.Education;
import com.myneu.pojo.ProfessionalEx;
import com.myneu.pojo.Skill;
import com.myneu.pojo.WorkRequestC2E;
import com.yusuf.spring.exception.AdException;

@Controller
public class ViewCandidateApplication {
	
	@Autowired
	EducationDAO educationDAO;
	
	@Autowired
	ExperienceDAO experienceDAO;
	
	@Autowired
	SkillDAO skillDAO;
	
	
	
	
	@RequestMapping(value="/viewcandidateprofile.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest1(HttpServletRequest hsra, HttpServletResponse hsr1a) throws Exception {
			List<Education> educationList = new ArrayList();
			 List educationaddList = null;
			
			 List<ProfessionalEx> experienceList = new ArrayList();
			 List experienceaddList = null;
		 
			 List<Skill> skillList = new ArrayList();
			 List skilladdList = null;
			 
		  String candidateEmail = hsra.getParameter("action");
		
		  
		  System.out.println("dfsdfdsfdsfdadfdsfd" +candidateEmail);
		  try{
			  //EducationDAO educationDAO= new EducationDAO();
			  //ExperienceDAO experienceDAO= new ExperienceDAO();
			 // SkillDAO skillDAO = new SkillDAO();
			  
			  
			  educationaddList = educationDAO.listEducation(candidateEmail);
			  experienceaddList = experienceDAO.listExperience(candidateEmail);
			  skilladdList = skillDAO.listSkill(candidateEmail);
			  
			  Iterator eduIterator = educationaddList.iterator();
			
			  while (eduIterator.hasNext())
		    {
				 
				  Education education = (Education) eduIterator.next();
				 
				  educationList.add(education);
				
			}  
			  
			  Iterator expIterator = experienceaddList.iterator();
				
			  while (expIterator.hasNext())
		    {
				 
				  ProfessionalEx professionalEx = (ProfessionalEx) expIterator.next();
				  experienceList.add(professionalEx);
			}  
			  
			  Iterator skillIterator = skilladdList.iterator();
				
			  while (skillIterator.hasNext())
		    {
				 
				  Skill skill = (Skill) skillIterator.next();
				  skillList.add(skill);
			}  
			  
			  
			  
			  
			  System.out.println("Array Size" +educationList.size());
			  System.out.println("Array Size" +experienceList.size());
			  System.out.println("Array Size" +skillList.size());
			  
		  }catch (AdException e) {
	    System.out.println(e.getMessage());
		  }
		  ModelAndView mv = new ModelAndView();
		  mv.addObject("education",educationList);
		  mv.addObject("experience",experienceList);
		  mv.addObject("skill",skillList);
		  mv.setViewName("candidateProfileView");
		  
		return mv;
	}
	
	
	@RequestMapping(value="/viewcandidateprofile1.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest2(HttpServletRequest hsrb, HttpServletResponse hsr1b) throws Exception {
			List<Education> educationList = new ArrayList();
			 List educationaddList = null;
			
			 List<ProfessionalEx> experienceList = new ArrayList();
			 List experienceaddList = null;
		 
			 List<Skill> skillList = new ArrayList();
			 List skilladdList = null;
			 
		  String candidateEmail = hsrb.getParameter("action");
		
		  
		  System.out.println("dfsdfdsfdsfdadfdsfd" +candidateEmail);
		  try{
			  //EducationDAO educationDAO= new EducationDAO();
			  //ExperienceDAO experienceDAO= new ExperienceDAO();
			 // SkillDAO skillDAO = new SkillDAO();
			  
			  
			  educationaddList = educationDAO.listEducation(candidateEmail);
			  experienceaddList = experienceDAO.listExperience(candidateEmail);
			  skilladdList = skillDAO.listSkill(candidateEmail);
			  
			  Iterator eduIterator = educationaddList.iterator();
			
			  while (eduIterator.hasNext())
		    {
				 
				  Education education = (Education) eduIterator.next();
				 
				  educationList.add(education);
				
			}  
			  
			  Iterator expIterator = experienceaddList.iterator();
				
			  while (expIterator.hasNext())
		    {
				 
				  ProfessionalEx professionalEx = (ProfessionalEx) expIterator.next();
				  experienceList.add(professionalEx);
			}  
			  
			  Iterator skillIterator = skilladdList.iterator();
				
			  while (skillIterator.hasNext())
		    {
				 
				  Skill skill = (Skill) skillIterator.next();
				  skillList.add(skill);
			}  
			  
			  
			  
			  
			  System.out.println("Array Size" +educationList.size());
			  System.out.println("Array Size" +experienceList.size());
			  System.out.println("Array Size" +skillList.size());
			  
		  }catch (AdException e) {
	    System.out.println(e.getMessage());
		  }
		  ModelAndView mv = new ModelAndView();
		  mv.addObject("education",educationList);
		  mv.addObject("experience",experienceList);
		  mv.addObject("skill",skillList);
		  mv.setViewName("candidateProfileView1");
		  
		return mv;
	}
}
