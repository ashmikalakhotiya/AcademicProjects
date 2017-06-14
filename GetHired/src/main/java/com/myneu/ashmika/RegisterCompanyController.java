package com.myneu.ashmika;


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

import com.myneu.dao.CompanyDAO;
import com.myneu.dao.LoginDAO;
import com.myneu.pojo.Company;
import com.myneu.pojo.UserAccount;
import com.yusuf.spring.exception.AdException;

@Controller
@RequestMapping("/addcompany.htm")
public class RegisterCompanyController {
	
	
	@Autowired
	@Qualifier("companyValidator")
	RegisterCompanyValidator validator;

	@Autowired
	CompanyDAO companyDAO;
	
	@Autowired
	LoginDAO loginDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("cmp") Company cmp, BindingResult result, HttpServletRequest hsr) throws Exception {
		
		 HttpSession session = hsr.getSession();
		validator.validate(cmp, result);
		if (result.hasErrors()) {
			return "addCompanyForm";
		}
		
		

		try {
			//System.out.print("test");
			
			//System.out.print("test1");

		//	CompanyDAO companyDAO = new CompanyDAO();
			companyDAO.create(cmp.getEmailID(), cmp.getPassword(), cmp.getConfirmPassword(), cmp.getCompanyName(),
					cmp.getLocation());
			
			String emailID = cmp.getEmailID();
            String password = cmp.getPassword();
			
			UserAccount ua = loginDAO.getUserAccount(emailID, password);
            
            if(ua !=null){
            session.setAttribute("email", emailID);
            session.setAttribute("user", ua);
			
			
            }

			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "loginsuccessCompany";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("cmp") Company cmp, BindingResult result) {

		return "addCompanyForm";
	}
}
