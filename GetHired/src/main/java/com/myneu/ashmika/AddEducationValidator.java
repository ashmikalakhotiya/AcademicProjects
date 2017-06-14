package com.myneu.ashmika;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myneu.pojo.Education;

public class AddEducationValidator implements Validator{
	
	private String alphastart = "^[a-zA-Z]+[0-9a-zA-Z\\s]*$";
	public boolean supports(Class aClass)
    {
        return aClass.equals(Education.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Education education = (Education) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "major", "error.invalid.user", "major Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "schoolName", "error.invalid.user", "schoolName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "degreeName", "error.invalid.user", "degreeName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "attendedFrom", "error.invalid.user", "attendedFrom Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "attendedTo", "error.invalid.user", "attendedTo Required");
        
        String schoolName = education.getSchoolName();
        String major = education.getMajor();
        String degreeName = education.getDegreeName();
    
    
    
    
        if(!(schoolName.matches(alphastart))){
	    	  
	    	  errors.rejectValue("schoolName", "Test", "School Name should start with alphabet followed by alphanumeric characters");
	      }
	      if(!(major.matches(alphastart))){
	  
	  errors.rejectValue("major", "Test", "Major should start with alphabet followed by alphanumeric characters");
	      }
	      if(!(degreeName.matches(alphastart))){
	    	  
	    	  errors.rejectValue("degreeName", "Test", "Degree Name should start with alphabet followed by alphanumeric characters");
	    	      }
    
    
    
    
    
    
    
    
    
    
    }
    
}
