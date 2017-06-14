package com.myneu.ashmika;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.myneu.dao.CompanyDAO;
import com.myneu.pojo.Candidate;
import com.yusuf.spring.exception.AdException;

public class RegisterCandidateValidator implements Validator  {
	
	private String emailPattern =  "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	private String passwordPattern =  "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$*()%]).{6,20})";
	private String alphastart = "^[a-zA-Z]+[0-9a-zA-Z\\s]*$";
	private static final String RESUME_PATTERN = "([^\\s]+(\\.(?i)(pdf|doc))$)";
	private String phonepattern = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	
	public boolean supports(Class aClass)
    {
        return aClass.equals(Candidate.class);
    }
//	Pattern pattern = Pattern.compile(RESUME_PATTERN);
//    Matcher matcher;
//    MultipartFile resume;
   

    public void validate(Object obj, Errors errors)
    {
    	Candidate candidate = (Candidate) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID", "error.invalid.user", "emailID Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.invalid.user", "confirmPassword Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "FirstName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "LastName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.invalid.user", "phone Required");
      //  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resumeName", "error.invalid.user", "Resume Required"); 
      // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resume", "error.invalid.user", "Resume Required"); 
        
//        resume = candidate.getResume();
//        
//       // matcher = pattern.matcher(resume.getOriginalFilename());
//        
//        if(0 == resume.getSize()) {
//           errors.rejectValue("resume","Test","File is empty");
//        }
////              if(!matcher.matches()) {
////             errors.rejectValue("resume","Test","Invalid File Format");
////        }
//        
//        if(5000000 < resume.getSize()) {
//             errors.rejectValue("resume","Test","File size is over 5mb !");
//        } 
       
       
       
       String emailId = candidate.getEmailID();
       String password = candidate.getPassword();
       String cpassword = candidate.getConfirmPassword();
       String firstName = candidate.getFirstName();
       String lastName = candidate.getLastName();
       String phone = candidate.getPhone();
       
     if(!(emailId.matches(emailPattern))) {
       	  errors.rejectValue("emailID", "Test", "Enter email ID with correct format");
       }
     if(!(password.matches(passwordPattern))){
   	  
   	  errors.rejectValue("password", "Test", "Password should contain alphanumeric characters");
     }
     if(!(cpassword.matches(passwordPattern))){
   	  
   	  errors.rejectValue("confirmPassword", "Test", "Password should contain alphanumeric characters");
     }
     if(!(firstName.matches(alphastart))){
   	  
   	  errors.rejectValue("firstName", "Test", "first NAme should start with alphabet");
     }
     if(!(lastName.matches(alphastart))){
 
 errors.rejectValue("lastName", "Test", "last NAme should start with alphabet");
     }
    
 if(!(phone.matches(phonepattern))){
    	 
    	 errors.rejectValue("phone", "Test", "should be in [3digits]-[3digits]-[4digits]");
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
