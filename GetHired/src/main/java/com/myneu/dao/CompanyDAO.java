package com.myneu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myneu.pojo.Candidate;
import com.myneu.pojo.Company;
import com.myneu.pojo.UserAccount;
import com.yusuf.spring.exception.AdException;

@Repository
public class CompanyDAO extends DAO{
	 
    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Job");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println(e.getMessage());
            throw new AdException("Could not list the jobs", e);
    
        }
    }
    
    public List list1(String emailID) throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Job where postedBy = :emailID");
            q.setString("emailID",emailID);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println(e.getMessage());
            throw new AdException("Could not list the jobs", e);
    
        }
    }
    
    
    public List list1(String jobTitle, String location) throws AdException {
        try {
            begin();
           // Query q = getSession().createQuery("from Job where jobTitle=:search AND location=:location");
            Query q = getSession().createQuery("from Job where jobTitle=:jobTitle OR location=:location");
            q.setString("jobTitle", jobTitle);
            q.setString("location",location);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println(e.getMessage());
            throw new AdException("Could not list the jobs", e);
    
        }
    }
    
    
    
    public List userAccountlist() throws AdException {
        try {
            begin();
            //Query q = getSession().createQuery("from UserAccount where type = :type");
            Query q = getSession().createQuery("from Company");
           // q.setString("type","company");
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
    
    public List listApplication(String company) throws AdException {
        try {
            begin();
            System.out.println("qqqqqqqqqqqqqq" +company);
            Query q = getSession().createQuery("from WorkRequestC2E where receiver = :company");
            q.setString("company", company);
            System.out.println("qqqqqqqqqqqqqq" +q);
            List list = q.list();
            System.out.println("+1++++++++++++++++" +list.size());
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println(e.getMessage());
            throw new AdException("Could not list the applications", e);
    
        }
    }
    
    
    public List listApplicationJob(String company) throws AdException {
        try {
            begin();
            System.out.println("qqqqqqqqqqqqqq" +company);
            Query q = getSession().createQuery("from WorkRequestC2E where sender = :company");
            q.setString("company", company);
            System.out.println("qqqqqqqqqqqqqq" +q);
            List list = q.list();
            System.out.println("+1++++++++++++++++" +list.size());
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println(e.getMessage());
            throw new AdException("Could not list the applications", e);
    
        }
    }
	    

	    public Company create(String emailID, String password, String confirmPassword, String companyName, String location)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            
	            Company cmp=new Company(emailID, password, confirmPassword, companyName, location);
	           //Company cmp =  new Company();
	           cmp.setEmailID(emailID);
	           cmp.setPassword(password);
	           cmp.setConfirmPassword(confirmPassword);
	           cmp.setCompanyName(companyName);
	           cmp.setLocation(location);
	           cmp.setType("company");
	      
	            
	            getSession().save(cmp);
	            
	            commit();
	            return cmp;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + emailId, e);
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	    }
	    
	    
	    
	    public void deleteCompany(int userid, String email)
	            throws AdException {
	    	 try {
	             begin();
	             System.out.println("qqqqqqqqqqqqqq" +userid);
	             System.out.println("qqqqqqqqqqqqqq" +email);
	             Query q = getSession().createQuery("delete from Company where userid = :userid");
	             Query q1 = getSession().createQuery("delete from Job where postedBy = :email");
	             q.setInteger("userid", userid);
	             q1.setString("email", email);
	             int result2 = q1.executeUpdate();
	             int result1 = q.executeUpdate();
	             
	             System.out.println("qqqqqqqqqqqqqq" +result1);
	             System.out.println("qqqqqqqqqqqqqq" +result2);
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
	    
	    
	    
	    public void deletejobfromCompany(int jobID)
	            throws AdException {
	    	 try {
	             begin();
	            
	             System.out.println("qqqqqqqqqqqqqq" +jobID);
	             Query q = getSession().createQuery("delete from Job where jobID = :jobID");
	             //Query q1 = getSession().createQuery("delete from Job where postedBy = :email");
	             q.setInteger("jobID", jobID);
	            // q1.setString("email", email);
	             //int result2 = q1.executeUpdate();
	             int result1 = q.executeUpdate();
	             
	             //System.out.println("qqqqqqqqqqqqqq" +result1);
	             System.out.println("qqqqqqqqqqqqqq" +result1);
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
	    
	    
	    
	    
	    

	    public void delete(Company cmp)
	            throws AdException {
	        try {
	            begin();
	            getSession().delete(cmp);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete user " + cmp.getCompanyName(), e);
	        }
	    }
	    
	    
	    public boolean isEmailPresent(String emailID) throws AdException{
	      
	    	boolean result = false;
	        try{
	        	begin();
	        
	        	Query q = getSession().createQuery("from UserAccount where emailID = :emailID");
	        	q.setString("emailID",emailID);
	        	List list = q.list();
	        	
	        	commit();
	            if(!list.isEmpty()) {
	            	result = true;
	            	
	            }
	           
	        }catch(HibernateException e) {
	            rollback();
	            throw new AdException("Exception while creating user: " + e.getMessage());
	        }
	        return result;
	   }
	    
	    public Company getCompany(UserAccount userAccount)throws AdException {
	    	 try {
	             begin();
	             int userid = userAccount.getUserid();
	             Query q = getSession().createQuery("from UserAccount where userid = :userid");
	             q.setInteger("userid",userid);
	             Company company = (Company) q.uniqueResult();
	             commit();
	             return company;
	         } catch (HibernateException e) {
	             rollback();
	             System.out.println(e.getMessage());
	             throw new AdException("Could not list the userAccount", e);
	     
	         }
	    }
	    
	    
}
