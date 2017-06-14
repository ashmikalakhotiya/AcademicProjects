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
import com.myneu.dao.JobPostDAO;
import com.myneu.dao.SkillDAO;
import com.myneu.pojo.Candidate;
import com.myneu.pojo.Education;
import com.myneu.pojo.Skill;
import com.myneu.pojo.UserAccount;
import com.yusuf.spring.exception.AdException;

@Controller
@RequestMapping("/addSkill.htm")
public class AddSkill {
	@Autowired
	@Qualifier("addskillvalidator")
	AddSkillValidator addskillvalidator;

	@Autowired
	SkillDAO skillDAO;
	
	@Autowired
	CandidateDAO candidateDAO;
	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(addskillvalidator);
	}
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("skill") Skill skill, BindingResult result, HttpServletRequest hsr) throws Exception {
		addskillvalidator.validate(skill, result);
		
		
		UserAccount ua = (UserAccount) hsr.getSession().getAttribute("user");
		//String userid = hsr.getParameter("user");
		
	
				
				
				
		if (result.hasErrors()) {
			return "addSkill";
		}

		try {
			//SkillDAO skillDAO = new SkillDAO();
			
			String email = hsr.getParameter("email");
			System.out.println("1111111111111111111" +email);
			
			Candidate candidate = candidateDAO.getCandidate(ua);				
			skillDAO.createskill(skill.getSkillname(), skill.getProficiency(), hsr.getParameter("email"), candidate);
			
			
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addSkillSuccess";
	}



	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("skill") Skill skill, BindingResult result) {

		return "addSkill";
	}
}
