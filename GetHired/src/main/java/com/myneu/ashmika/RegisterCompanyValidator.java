package com.myneu.ashmika;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myneu.dao.CompanyDAO;
import com.myneu.pojo.Company;
import com.yusuf.spring.exception.AdException;



public class RegisterCompanyValidator implements Validator {
	 
	private String emailPattern =  "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private String passwordPattern =  "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$*()%]).{6,20})";
	private String alphastart = "^[a-zA-Z]+[0-9a-zA-Z\\s]*$";
	
	public boolean supports(Class aClass)
	    {
	        return aClass.equals(Company.class);
	    }

	    public void validate(Object obj, Errors errors)
	    {
	    	
	    	
	        Company cmp = (Company) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID", "error.invalid.user", "emailID Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "password Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.invalid.user", "confirmPassword Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.user", "companyName Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.user", "Location Required");
	        
	        String emailId = cmp.getEmailID();
	        String password = cmp.getPassword();
	        String cpassword = cmp.getConfirmPassword();
	        String companyName = cmp.getCompanyName();
	        String location = cmp.getLocation();
	        
	      if(!(emailId.matches(emailPattern))) {
	        	  errors.rejectValue("emailID", "Test", "Enter email ID with correct format");
	        }
	      if(!(password.matches(passwordPattern))){
	    	  
	    	  errors.rejectValue("password", "Test", "Password should contain alphanumeric characters");
	      }
	      if(!(cpassword.matches(passwordPattern))){
	    	  
	    	  errors.rejectValue("confirmPassword", "Test", "Password should contain alphanumeric characters");
	      }
	      if(!(companyName.matches(alphastart))){
	    	  
	    	  errors.rejectValue("companyName", "Test", "Company NAme hould start with alphabet followed by alphanumeric characters");
	      }
	      if(!(location.matches(alphastart))){
	  
	  errors.rejectValue("location", "Test", "Location should start with alphabet followed by alphanumeric characters");
	      }
	      
	      
	      
	      
	      CompanyDAO compDAO = new CompanyDAO();
	        Boolean present;
			try {
				present = compDAO.isEmailPresent(emailId);
				
				if(present == true){
		        	 errors.rejectValue("emailID", "error.invalid.user", "Username already in use");
		        }
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	     }
			
}
