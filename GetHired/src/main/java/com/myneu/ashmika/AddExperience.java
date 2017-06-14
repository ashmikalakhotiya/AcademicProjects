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
import com.myneu.dao.EducationDAO;
import com.myneu.dao.ExperienceDAO;
import com.myneu.pojo.Candidate;
import com.myneu.pojo.Education;
import com.myneu.pojo.ProfessionalEx;
import com.myneu.pojo.UserAccount;
import com.yusuf.spring.exception.AdException;

@Controller
@RequestMapping("/addExperience.htm")
public class AddExperience {
	@Autowired
	@Qualifier("addexperiencevalidator")
	AddExperienceValidator addexperiencevalidator;

	@Autowired
	ExperienceDAO experienceDAO;
	
	@Autowired
	CandidateDAO candidateDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(addexperiencevalidator);
	}
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("professionalEx") ProfessionalEx professionalEx, BindingResult result,  HttpServletRequest hsr) throws Exception {
		addexperiencevalidator.validate(professionalEx, result);
		if (result.hasErrors()) {
			return "addExperience";
		}
		
		UserAccount ua = (UserAccount) hsr.getSession().getAttribute("user");
		

		try {
		
			Candidate candidate = candidateDAO.getCandidate(ua);
			
			//ExperienceDAO experienceDAO = new ExperienceDAO();
			experienceDAO.createexperience(professionalEx.getCompanyName(), professionalEx.getStartDate(), professionalEx.getEndDate(),
					professionalEx.getDesignation(), professionalEx.getResponsibilities(), hsr.getParameter("email"), candidate);
					
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addExperienceSuccess";
	}



	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("professionalEx") ProfessionalEx professionalEx, BindingResult result) {

		return "addExperience";
	}
}
