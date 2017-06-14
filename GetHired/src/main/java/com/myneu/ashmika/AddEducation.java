package com.myneu.ashmika;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myneu.dao.CandidateDAO;
import com.myneu.dao.CompanyDAO;
import com.myneu.dao.EducationDAO;
import com.myneu.dao.JobPostDAO;
import com.myneu.pojo.Candidate;
import com.myneu.pojo.Education;
import com.myneu.pojo.Job;
import com.myneu.pojo.UserAccount;
import com.yusuf.spring.exception.AdException;

@Controller
@RequestMapping("/addEducation.htm")
public class AddEducation {
	@Autowired
	@Qualifier("addeducationvalidator")
	AddEducationValidator addeducationvalidator;

	@Autowired
	EducationDAO educationDAO;
	
	@Autowired
	CandidateDAO candidateDAO;
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(addeducationvalidator);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("education") Education education, BindingResult result, HttpServletRequest hsr) throws Exception {
		addeducationvalidator.validate(education, result);
		if (result.hasErrors()) {
			return "addEducation";
		}

		UserAccount ua = (UserAccount) hsr.getSession().getAttribute("user");
		
		
		
		
		try {
			//EducationDAO educationDAO = new EducationDAO() ;
			
			String email = hsr.getParameter("email");
			System.out.println("1111111111111111111" +email);
			
			Candidate candidate = candidateDAO.getCandidate(ua);		
			
			
			educationDAO.createeducation(education.getDegreeName(), education.getAttendedFrom(), 
					education.getAttendedTo(), education.getMajor(), education.getSchoolName(), hsr.getParameter("email"), candidate);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addEducationSuccess";
	}



	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("education") Education education, BindingResult result) {

		return "addEducation";
	}
}
