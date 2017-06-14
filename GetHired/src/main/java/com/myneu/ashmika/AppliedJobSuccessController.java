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

import com.myneu.dao.CandidateDAO;
import com.myneu.dao.CompanyDAO;
import com.myneu.dao.LoginDAO;
import com.myneu.pojo.Candidate;
import com.myneu.pojo.UserAccount;
import com.myneu.pojo.WorkRequestC2E;
import com.yusuf.spring.exception.AdException;

@Controller
//@RequestMapping("/jobPostSuccess.htm")
public class AppliedJobSuccessController {
	
	@Autowired
	CompanyDAO companyDAO;
	
	@Autowired
	CandidateDAO cdao;
	
	@Autowired
	LoginDAO loginDAO;
	
	
	
	@RequestMapping(value="/jobPostSuccess.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		
		UserAccount ua = (UserAccount) hsr.getSession().getAttribute("user");
		
		Candidate candidate = cdao.getCandidate(ua);		
		
		  ModelAndView mv = new ModelAndView();
		  String postedby = hsr.getParameter("candidate");
		  String receiver = hsr.getParameter("postedby");
		  String companyName = hsr.getParameter("companyName");
		  Integer jobID = Integer.parseInt(hsr.getParameter("jobID"));
		  
		// CandidateDAO cdao = new CandidateDAO();
		 cdao.createworkrequest(postedby, receiver, candidate, companyName, jobID );
		
		  mv.setViewName("applyJobSuccess");
		
		return mv;
	}
	
	
	@RequestMapping(value="/appliedjobcandidate.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest1(HttpServletRequest hsra, HttpServletResponse hsr1a) throws Exception {
			List<WorkRequestC2E> appList = new ArrayList();
			 List appaddList = null;
			
		 
		
		  String employer = hsra.getParameter("email");
		  
		  
		  System.out.println("TTTTTTTTTTTTTTTTTTTTTTT" +employer);
		  try{
			 // CompanyDAO companyDAO= new CompanyDAO();
			 
			  appaddList = companyDAO.listApplication(employer);
		
			  Iterator appIterator = appaddList.iterator();
			
			  while (appIterator.hasNext())
		    {
				 
				  WorkRequestC2E workRequestC2E = (WorkRequestC2E) appIterator.next();
				 
				  appList.add(workRequestC2E);
				
			}  
			  
		 
		  }catch (AdException e) {
	    System.out.println(e.getMessage());
		  }
		  ModelAndView mv = new ModelAndView("applyApplication","apps", appList);
		return mv;
	}
	
	
	@RequestMapping(value="/homepageCandidate.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest2(HttpServletRequest hsrb, HttpServletResponse hsr1b) throws Exception {
		
		  ModelAndView mv = new ModelAndView();
		  
		  HttpSession session = hsrb.getSession();
	        
		  System.out.println("coming hereeeeeeeeeeeeeeeee");
	        
	      
	        	 String emailID = (String) session.getAttribute("email");
	        	 System.out.println("emaillllllllll" +emailID);
	        	
	            
	            // LoginDAO loginDAO = new LoginDAO();
	             UserAccount ua = loginDAO.getUserAccount1(emailID);
	             
	             session.setAttribute("email", emailID);
	             String type = ua.getType();
	                     
	             if(type.equals("company")){
	                 
	                 mv.setViewName("loginsuccessCompany");
	                 }
	                 else if(type.equals("admin")){
	                mv.setViewName("adminHomePage"); 
	                	 
	                 }
	                 else{
	                	 
	                	 mv.setViewName("loginsuccessCandidate");
	                 }
	         
		  
		
		return mv;
	}
	
	
}







