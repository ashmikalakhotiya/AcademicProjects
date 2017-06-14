package com.myneu.ashmika;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myneu.dao.LoginDAO;
import com.myneu.pojo.UserAccount;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	
	@Autowired
	LoginDAO loginDAO;
	 
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
        HttpSession session = hsr.getSession();
        String action = hsr.getParameter("action");
        ModelAndView mv = new ModelAndView();
        
        if(action.equals("login")){
        	 String emailID = hsr.getParameter("email");
             String password = hsr.getParameter("password");
                   
             //LoginDAO loginDAO = new LoginDAO();
             UserAccount ua = loginDAO.getUserAccount(emailID, password);
             
             if(ua !=null){
             session.setAttribute("email", emailID);
             session.setAttribute("user", ua);
             String type = ua.getType();
             
             System.out.println("tttyyyyppppeee" +type);
             if(type.equals("company")){
            
             mv.setViewName("loginsuccessCompany");
             }
             else if(type.equals("admin")){
            mv.setViewName("adminHomePage"); 
            	 
             }
             else{
            	 
            	 mv.setViewName("loginsuccessCandidate");
             }
             } 
             else{
                 mv.addObject("invalidCredentials", "true");
                 
                 mv.setViewName("home");
             }
             
        }
        
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView handleRequest1(HttpServletRequest hsrd, HttpServletResponse hsrd1) throws Exception {
        
        HttpSession session = hsrd.getSession();
        String action = hsrd.getParameter("action");
        ModelAndView mv = new ModelAndView();
        if (action.equals("logout")){
        	session.invalidate();
            mv.setViewName("home");
        	
        }
        return mv;
	}
	
	
}
