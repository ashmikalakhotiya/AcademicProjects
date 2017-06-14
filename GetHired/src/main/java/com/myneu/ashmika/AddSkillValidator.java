package com.myneu.ashmika;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myneu.pojo.Education;
import com.myneu.pojo.Skill;


public class AddSkillValidator implements Validator {
	
	private String alphastart = "^[a-zA-Z]+[0-9a-zA-Z\\s]*$";
	
	public boolean supports(Class aClass)
    {
        return aClass.equals(Skill.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Skill skill = (Skill) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skillname", "error.invalid.user", "Skill Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "proficiency", "error.invalid.user", "Proficiency Required");
    
    
    String skillName = skill.getSkillname();
 
    if(!(skillName.matches(alphastart))){
    	  
    	  errors.rejectValue("skillName", "Test", "Skill Name should start with alphabet followed by alphanumeric characters");
      }
    
    }
}
