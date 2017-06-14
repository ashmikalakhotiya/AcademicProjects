package com.myneu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.myneu.pojo.Candidate;
import com.myneu.pojo.Company;
import com.myneu.pojo.UserAccount;
import com.myneu.pojo.WorkRequestC2E;
import com.yusuf.spring.exception.AdException;

@Repository
public class CandidateDAO extends DAO {
	
	public CandidateDAO(){
		
	}
		
		public Candidate create(String emailID, String password, String confirmPassword, String firstName, String lastName,
				String resumeName, byte[] resume, String phone)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
            Candidate candidate=new Candidate(emailID, password, confirmPassword, firstName, lastName, resumeName, resume, phone);
	            
	        //    Candidate candidate =  new Candidate();
	            candidate.setEmailID(emailID);
	            candidate.setPassword(password);
	            candidate.setConfirmPassword(confirmPassword);
	            candidate.setFirstName(firstName);
	            candidate.setLastName(lastName);
	           candidate.setResumeName(resumeName);
	           candidate.setResume(resume);
	            candidate.setType("candidate");
	            candidate.setPhone(phone);
	           
	             getSession().save(candidate);
	            
	            commit();
	            return candidate;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + emailId, e);
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	    }
		
	public WorkRequestC2E createworkrequest(String sender, String receiver, Candidate c, String companyName, Integer jobId)
	            throws AdException {
        try {
	            begin();
	            System.out.println("inside DAO");
	            
	            System.out.println("aaaaaaa" +sender);
	            
            WorkRequestC2E requestC2E = new WorkRequestC2E();
	  		requestC2E.setSender(sender);
	  		requestC2E.setReceiver(receiver);
	  		requestC2E.setStatus("SENT");
	  		requestC2E.setCandidate(c);
	  		requestC2E.setJobID(jobId);
	  		requestC2E.setCompanyName(companyName);
           
	            
            getSession().save(requestC2E);
            
	            commit();
	            return requestC2E;
        } catch (HibernateException e) {
            rollback();
	            //throw new AdException("Could not create user " + emailId, e);
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	    }
		
	public void deleteCandidate(int userid, String email)
            throws AdException {
    	 try {
             begin();
             System.out.println("qqqqqqqqqqqqqq" +userid);
             System.out.println("qqqqqqqqqqqqqq" +email);
             Query q1 = getSession().createQuery("delete from Education where userid = :userid");
             Query q2 = getSession().createQuery("delete from ProfessionalEx where userid = :userid");
             Query q3 = getSession().createQuery("delete from Skill where userid = :userid");
             Query q4 = getSession().createQuery("delete from WorkRequestC2E where sender = :email");
             Query q = getSession().createQuery("delete from Candidate where userid = :userid");
             q1.setInteger("userid", userid);
             q2.setInteger("userid", userid); 
             q3.setInteger("userid", userid); 
             q.setInteger("userid", userid); 
             q4.setString("email", email);
            
             int result2 = q1.executeUpdate();
             int result3 = q2.executeUpdate();
             int result4 = q3.executeUpdate();
             int result5 = q4.executeUpdate();
             int result1 = q.executeUpdate();
             
            
        
            // List list = q.list();
            // System.out.println("+1++++++++++++++++" +list.size());
             commit();
             //return result1;
         } catch (HibernateException e) {
             rollback();
             System.out.println(e.getMessage());
             throw new AdException("Could not list the applications", e);
     
         }
        
    }	
	
	
    public List userAccountlist() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from UserAccount where type = :type");
            q.setString("type","candidate");
            List list = q.list();
            System.out.println("qqqqqqqq11111111111qqqqqq" +q);
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println(e.getMessage());
            throw new AdException("Could not list the userAccount", e);
    
        }
    }
    
    public Candidate getCandidate(UserAccount userAccount)throws AdException {
    	 try {
             begin();
             int userid = userAccount.getUserid();
             Query q = getSession().createQuery("from UserAccount where userid = :userid");
             q.setInteger("userid",userid);
            Candidate candidate = (Candidate) q.uniqueResult();
             commit();
             return candidate;
         } catch (HibernateException e) {
             rollback();
             System.out.println(e.getMessage());
             throw new AdException("Could not list the userAccount", e);
     
         }
    	
    	
    	
    }
		
		
		
		

	    public void delete(Candidate candidate)
	            throws AdException {
	        try {
	            begin();
	            getSession().delete(candidate);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete user " + candidate.getFirstName(), e);
	        }
	    }
}
