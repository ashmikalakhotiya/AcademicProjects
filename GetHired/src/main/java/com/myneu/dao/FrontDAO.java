package com.myneu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.yusuf.spring.exception.AdException;

@Repository
public class FrontDAO extends DAO {
 
	public List listEducation(String candidateEmail) throws AdException {
        try {
            begin();
            System.out.println("aaaaaaaaaaa" +candidateEmail);
            Query q = getSession().createQuery("from Education where candidateEmail = :candidateEmail");
            q.setString("candidateEmail", candidateEmail);
            System.out.println("ssssssssssssss" +q);
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
