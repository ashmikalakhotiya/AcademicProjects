package com.myneu.ashmika;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myneu.dao.CompanyDAO;
import com.myneu.pojo.Job;
import com.yusuf.spring.exception.AdException;

@Controller

public class FrontController {

	@Autowired
	CompanyDAO companyDAO;
	
	@RequestMapping(value="/searchJob.htm", method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        List<Job> jobList = new ArrayList();
		 List jobaddList = null;
		
        HttpSession session = hsr.getSession();
       // ModelAndView mv = new ModelAndView();
        String action = hsr.getParameter("action");
        if(action.equals("front")){
       	 String jobTitle = hsr.getParameter("search");
         String location = hsr.getParameter("location");
        
         System.out.println("search" +jobTitle);
         System.out.println("search" +location);
         
 		 try {
         	
         	//CompanyDAO companyDAO = new CompanyDAO();
         	jobaddList = companyDAO.list1(jobTitle,location);
         	
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
         
         
 			}
        ModelAndView mv = new ModelAndView("viewJobFront", "jobs", jobList);
        
        return mv;
	}
	
	@RequestMapping(value="/viewFrontJobLogin.htm")
	public ModelAndView handleRequest6(HttpServletRequest hsrf, HttpServletResponse hsr1f) {

		  ModelAndView mv = new ModelAndView();
		  String postedby = hsrf.getParameter("candidate");
		  String receiver = hsrf.getParameter("postedby");
		  String companyName = hsrf.getParameter("companyName");
		  Integer jobID = Integer.parseInt(hsrf.getParameter("jobID"));
	
		  System.out.println("asasasass postedby" +postedby);
		  System.out.println("asasasass receiver" +receiver);
		  System.out.println("asasasass companyName" +companyName);
		  System.out.println("asasasass jobID" +jobID);
		  
		  mv.addObject("postedby", postedby);
		  mv.addObject("receiver", receiver);
		  mv.addObject("companyName", companyName);
		  mv.addObject("jobID", jobID);
		  mv.setViewName("viewFrontJobLogin");
	 return mv;
}
}
