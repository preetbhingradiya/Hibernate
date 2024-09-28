	package com.hibernate.criteria;
	
	import java.util.List;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	
	import com.hibernate.EmpDetails;
import com.mapping.I10;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
	
	public class CriteriaDemo {
	
		public static void main(String[] args) {
			
			SessionFactory factory = new Configuration().configure("oneToOneCon.xml").buildSessionFactory();
			
			Session session = factory.openSession();
	 		
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<I10> criteria = builder.createQuery(I10.class);
	        
	        // Define the root of the query
	        Root<I10> root = criteria.from(I10.class);

	        // Create a predicate for filtering seats = 4
	        Predicate seatPredicate = builder.equal(root.get("seats"), 4);
	        
	        // Apply the predicate to the query
	        criteria.select(root).where(seatPredicate);

	        List<I10> vehicles = session.createQuery(criteria).getResultList();
	
	        for (I10 vehicle : vehicles) {
	            System.out.println(vehicle);
	        }
			
			session.close();
			factory.close();
	
		}
	
	}
