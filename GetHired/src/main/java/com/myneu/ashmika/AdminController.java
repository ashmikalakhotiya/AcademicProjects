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
import com.myneu.pojo.Company;
import com.myneu.pojo.Job;
import com.myneu.pojo.UserAccount;
import com.yusuf.spring.exception.AdException;

@Controller
public class AdminController {

	
	@Autowired
	CompanyDAO companyDAO;
	
	@Autowired
	CandidateDAO candidateDAO;
	
	
	
	
	@RequestMapping(value="/deleteCompany.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		
		System.out.println("baaaakaaar");
		  List<Company> uaList = new ArrayList();
		  // List<UserAccount> uaList = new ArrayList();
			List uaaddList = null;

	        try {
	        	
	        	//CompanyDAO companyDAO = new CompanyDAO();
	        	uaaddList = companyDAO.userAccountlist();
	        	
	        	Iterator uaIterator = uaaddList.iterator();

	            while (uaIterator.hasNext())
	            {
	            	Company company = (Company) uaIterator.next();
	            	//UserAccount userAccount = (UserAccount) uaIterator.next();
	            	//uaList.add(userAccount);
	            	uaList.add(company);
	            }
		
		System.out.println("sdsfdsfsdfsdfsdf" +uaList.size());
	}catch (AdException e) {
        System.out.println(e.getMessage());
    }
	        ModelAndView mv = new ModelAndView("adminUAcompany","ua", uaList);
	return mv;
	        
	}
	
	
	@RequestMapping(value="/deletecompanyfinally.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest2(HttpServletRequest hsrb, HttpServletResponse hsr1b) throws Exception {
		
		try{
		int userid = Integer.parseInt(hsrb.getParameter("userid"));
		String email = hsrb.getParameter("email");
				
		System.out.println("userid" +userid);
		System.out.println("email" +email);
	  
	     companyDAO.deleteCompany(userid,email);
	        	
	        	
		
		System.out.println("company deleted");
	}catch (AdException e) {
        System.out.println(e.getMessage());
    }
	        ModelAndView mv = new ModelAndView("adminDeleteCompany");
	return mv;
	        
	}
	
	

	@RequestMapping(value="/deletecandidatefinally.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest4(HttpServletRequest hsrd, HttpServletResponse hsr1d) throws Exception {
		
		try{
		int userid = Integer.parseInt(hsrd.getParameter("userid"));
		String email = hsrd.getParameter("email");
				
		System.out.println("userid" +userid);
		System.out.println("email" +email);
	  
	     candidateDAO.deleteCandidate(userid,email);
	        	
	        	
		
		System.out.println("candidate deleted");
	}catch (AdException e) {
        System.out.println(e.getMessage());
    }
	        ModelAndView mv = new ModelAndView("adminDeleteCompany");
	return mv;
	        
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/deleteCandidate.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest1(HttpServletRequest hsra, HttpServletResponse hsr1a) throws Exception {
		
		System.out.println("baaaakaaarrrrrrrrrrrrrrrrrrr");
		  // List<Company> uaList = new ArrayList();
		   List<UserAccount> uaList = new ArrayList();
			List uaaddList = null;

	        try {
	        	
	        	//CompanyDAO companyDAO = new CompanyDAO();
	        	uaaddList = candidateDAO.userAccountlist();
	        	
	        	Iterator uaIterator = uaaddList.iterator();

	            while (uaIterator.hasNext())
	            {
	            	//Company company = (Company) uaIterator.next();
	            	UserAccount userAccount = (UserAccount) uaIterator.next();
	            	uaList.add(userAccount);
	            }
		
		System.out.println("sdsfdsfsdfsdfsdf" +uaList.size());
	}catch (AdException e) {
        System.out.println(e.getMessage());
    }
	        ModelAndView mv = new ModelAndView("adminUAcandidate","ua", uaList);
	return mv;
	        
	}
	
	

	
	@RequestMapping(value="/deletejobFromCompany.htm", method=RequestMethod.GET)
	public ModelAndView handleRequest7(HttpServletRequest hsrg, HttpServletResponse hsr1g) throws Exception {
		
		try{
		
		//String email = hsrg.getParameter("email");
		int jobID = Integer.parseInt(hsrg.getParameter("jobID"));	
		
		System.out.println("jobID" +jobID);
	  
	     companyDAO.deletejobfromCompany(jobID);
	        	
	        	
		
		System.out.println("company deleted");
	}catch (AdException e) {
        System.out.println(e.getMessage());
    }
	        ModelAndView mv = new ModelAndView("deleteJobFromCompany");
	return mv;
	        
	}
	
	
	
	
}
