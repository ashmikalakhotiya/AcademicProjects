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

import com.myneu.dao.CompanyDAO;
import com.myneu.dao.JobPostDAO;
import com.myneu.pojo.Company;
import com.myneu.pojo.Job;
import com.myneu.pojo.WorkRequestC2E;
import com.yusuf.spring.exception.AdException;


@Controller
public class LookJobCandidate {
	
	@Autowired
	CompanyDAO companyDAO;
	
	
	@RequestMapping(value="/lookjob.htm", method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Job> jobList = new ArrayList();
		List jobaddList = null;

        try {
        	
        	//CompanyDAO companyDAO = new CompanyDAO();
        	jobaddList = companyDAO.list();
        	
        	Iterator categIterator = jobaddList.iterator();

            while (categIterator.hasNext())
            {
            	Job job = (Job) categIterator.next();
            	jobList.add(job);
            }
            //DAO.close();
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        ModelAndView mv = new ModelAndView("viewJob", "jobs", jobList);
      
        return mv;
       
        
    }
	
	
	@RequestMapping(value="/viewjobscompany.htm", method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal1(HttpServletRequest request2, HttpServletResponse response2) throws Exception {
		List<Job> jobList = new ArrayList();
		List jobaddList = null;

		String email = request2.getParameter("email");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxx" +email);
        try {
        	
        	//CompanyDAO companyDAO = new CompanyDAO();
        	jobaddList = companyDAO.list1(email);
        	
        	Iterator categIterator = jobaddList.iterator();

            while (categIterator.hasNext())
            {
            	Job job = (Job) categIterator.next();
            	jobList.add(job);
            }
            //DAO.close();
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        ModelAndView mv = new ModelAndView("viewJobCompany", "jobs", jobList);
      
        return mv;
       
        
    }
	
	
	
	
	
	@RequestMapping(value="/viewJobs.htm", method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal8(HttpServletRequest request8, HttpServletResponse response8) throws Exception {
		
		List<WorkRequestC2E> appList = new ArrayList();
		 List appaddList = null;
		
	 
	
	  String candidate = request8.getParameter("email");
	  try{
		 // CompanyDAO companyDAO= new CompanyDAO();
		 
		  appaddList = companyDAO.listApplicationJob(candidate);
	
		  Iterator appIterator = appaddList.iterator();
		
		  while (appIterator.hasNext())
	    {
			 
			  WorkRequestC2E workRequestC2E = (WorkRequestC2E) appIterator.next();
			 
			  appList.add(workRequestC2E);
			
		}  
		  
	 
	  }catch (AdException e) {
   System.out.println(e.getMessage());
	  }
	  ModelAndView mv = new ModelAndView("viewCandidateApplication","apps", appList);
	return mv;
}
       
        
    }
	
	
	
	
	




