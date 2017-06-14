package com.myneu.ashmika;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.myneu.dao.CandidateDAO;
import com.myneu.dao.CompanyDAO;
import com.myneu.dao.LoginDAO;
import com.myneu.pojo.Candidate;
import com.myneu.pojo.Company;
import com.myneu.pojo.UserAccount;
import com.yusuf.spring.exception.AdException;

@Controller
public class RegisterCandidateController {
	@Autowired
	@Qualifier("candidateValidator")
	RegisterCandidateValidator cvalidator;

	@Autowired
	CandidateDAO candidateDAO;
	
	@Autowired
	LoginDAO loginDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(cvalidator);
	}

	@RequestMapping(value= "/addcandidate.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("candidate") Candidate candidate, BindingResult result,HttpServletRequest hsr, @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
		
		 HttpSession session = hsr.getSession();
		cvalidator.validate(candidate, result);
		if (result.hasErrors()) {
			return "addCandidateForm";
		}

		try {
			//System.out.print("test");
		
			//System.out.print("test1");
			
			
			String resumeName = null;
			byte[] resume = null;
			 if (fileUpload != null && fileUpload.length > 0) {
	    	        for (CommonsMultipartFile reumeFile : fileUpload){
	    	              
	    	            System.out.println("Saving file: " + reumeFile.getOriginalFilename());
	    	             
	    	            //Candidate uploadFile = new Candidate();
	    	           
	    	            resumeName = reumeFile.getOriginalFilename();
	    	            resume = reumeFile.getBytes();
	    	                           
	    	        }
	    	 }
			
			
			
			
			
			
		//	CandidateDAO candidateDAO = new CandidateDAO();
			
			candidateDAO.create(candidate.getEmailID(), candidate.getPassword(), candidate.getConfirmPassword(), 
					candidate.getFirstName(), candidate.getLastName(), resumeName, resume, candidate.getPhone());

			String emailID = candidate.getEmailID();
            String password = candidate.getPassword();
			
			UserAccount ua = loginDAO.getUserAccount(emailID, password);
            
            if(ua !=null){
            session.setAttribute("email", emailID);
            session.setAttribute("user", ua);
			
			
            }
			
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "loginsuccessCandidate";
	}

	@RequestMapping(value= "/addcandidate.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("candidate") Candidate candidate, BindingResult result) {

		return "addCandidateForm";
	}
}
