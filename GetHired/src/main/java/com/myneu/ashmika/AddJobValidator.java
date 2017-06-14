package com.myneu.ashmika;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.myneu.pojo.Job;

public class AddJobValidator implements Validator {
	private String pattern = "^[a-zA-Z]+[0-9a-zA-Z\\s]*$";
	private String exppattern = "^(0?[1-9]|[1-9][0-9])$";
	private String phonepattern = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	
	public boolean supports(Class aClass)
    {
        return aClass.equals(Job.class);
    }
	


    public void validate(Object obj, Errors errors)
    {
        Job job = (Job) obj;
      //  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobID", "error.invalid.user", "emailID Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "error.invalid.user", "password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDescription", "error.invalid.user", "confirmPassword Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobType", "error.invalid.user", "companyName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experience", "error.invalid.user", "Location Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skills", "error.invalid.user", "emailID Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qualification", "error.invalid.user", "password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.user", "confirmPassword Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postedOn", "error.invalid.user", "companyName Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postedBy", "error.invalid.user", "Location Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "industry", "error.invalid.user", "Location Required");
        
        String jobtitle = job.getJobTitle();
        String jobDescription = job.getJobDescription();
        String jobType = job.getJobType();
        String experience = String.valueOf(job.getExperience());
        String skill = job.getSkills();
        String qualification = job.getQualification();
        String location = job.getLocation();
        String industry = job.getIndustry();
        
        if(!(jobtitle.matches(pattern))) {
      	  errors.rejectValue("jobTitle", "Test", "Should start with alphabet");
      }
        if(!(jobDescription.matches(pattern))) {
        	  errors.rejectValue("jobDescription", "Test", "Should start with alphabet");
        }
        if(!(jobType.matches(pattern))) {
        	  errors.rejectValue("jobType", "Test", "Should start with alphabet");
        }
        if(!(experience.matches(exppattern))) {
        	  errors.rejectValue("experience", "Test", "Must be 2 digits");
        }
        if(!(qualification.matches(pattern))) {
      	  errors.rejectValue("qualification", "Test", "Should start with alphabet");
      }
       
        if(!(location.matches(pattern))) {
        	  errors.rejectValue("location", "Test", "Should start with alphabet");
        }
          if(!(industry.matches(pattern))) {
        	  errors.rejectValue("industry", "Test", "Should start with alphabet");
        }
      
     }
}
