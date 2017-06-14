package com.myneu.ashmika;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.myneu.dao.JobPostDAO;
import com.myneu.pojo.Candidate;
import com.myneu.pojo.Company;
import com.myneu.pojo.Job;
import com.myneu.pojo.UserAccount;
import com.yusuf.spring.exception.AdException;

@Controller
@RequestMapping("/addjob.htm")
public class AddJobController {
	@Autowired
	@Qualifier("addJobValidator")
	AddJobValidator addJobvalidator;

	@Autowired
	JobPostDAO jobPostDAO;
	
	@Autowired
	CompanyDAO companyDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(addJobvalidator);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("job") Job job, BindingResult result, HttpServletRequest hsr) throws Exception {
		addJobvalidator.validate(job, result);
		if (result.hasErrors()) {
			return "addJob";
		}
		
		UserAccount userAccount = (UserAccount) hsr.getSession().getAttribute("user");
		String postedBy = userAccount.getEmailID(); 

		Company company = companyDAO.getCompany(userAccount);
		try {
			//JobPostDAO jobPostDAO = new JobPostDAO();
			
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String postedOn = dateFormat.format(date);
			
			System.out.println("postedon"  +postedOn);
			System.out.println("postedBy" +postedBy);
			String companyName = company.getCompanyName();
			System.out.println("postedon"  +companyName);
			
			jobPostDAO.createjob(job.getJobTitle(), job.getJobDescription(), job.getJobType(), job.getExperience(), job.getSkills(),
					job.getQualification(), job.getLocation(), postedOn, postedBy, job.getIndustry(),company, companyName );
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedJob";
	}



	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("job") Job job, BindingResult result) {

		return "addJob";
	}
}
