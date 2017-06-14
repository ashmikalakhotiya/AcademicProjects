package com.myneu.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myneu.pojo.UserAccount;
import com.yusuf.spring.exception.AdException;

@Repository
public class LoginDAO extends DAO {
	
    public UserAccount getUserAccount(String emailID, String password) throws AdException{
  
    	        try {
    	            begin();
    	            Query q = getSession().createQuery("from UserAccount where emailID = :emailID AND password = :password");
    	            q.setString("emailID", emailID);
    	            q.setString("password", password);
    	            UserAccount useraccount = (UserAccount) q.uniqueResult();
    	            commit();
    	            return useraccount;
    	        } catch (HibernateException e) {
    	            rollback();
    	            throw new AdException("Could not get user " + emailID, e);
    	        }
    }
    
    public UserAccount getUserAccount1(String emailID) throws AdException{
    	  
        try {
            begin();
            Query q = getSession().createQuery("from UserAccount where emailID = :emailID");
            q.setString("emailID", emailID);
            UserAccount useraccount = (UserAccount) q.uniqueResult();
            commit();
            return useraccount;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + emailID, e);
        }
    }
        
        public List fetchjobs(String jobsearch, String joblocation )throws AdException{
        	try {
	            begin();
	            System.out.println("ooooooooooooiiii" +jobsearch);
	            System.out.println("ooooooooooooiiii" +joblocation);
	            
	            
	            Query q = getSession().createQuery("from ProfessionalEx where location = :joblocation AND postedBy = :jobsearch  ");
	            q.setString("jobsearch", jobsearch);
	            q.setString("joblocation", joblocation);
	            
	            System.out.println("yuuuuuuuuyuyuyu" +q);
	            List list = q.list();
	            System.out.println("in DAO Array Size" +list.size());
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            System.out.println(e.getMessage());
	            throw new AdException("Could not list the eduation details", e);
	    
	        }
        	
        	
        	
        	
        }

	
}
