package com.hibernate.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mapping.OneToMany.Answer;

public class HQLPagination {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("oneToMany.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
//		Query<Answer> query = session.createQuery("from Answer");
		
		
		//Implelemenet pagination in 1 page how many item
//		query.setFirstResult(0);  //start from 0 index number data
//		
//		query.setMaxResults(2);  //ending from 2 data give menas index (0,1) data return	
		
		//use of SQL query
		Query query = session.createNativeQuery("select * from answer where id = :x", Answer.class);
		query.setParameter("x", 1);
		

		
		List<Answer> list = query.list();
		
		for(Answer st : list) {
			System.out.println(st.getId() + " " + st.getContent());
		}
		
		
		
		session.close();
		factory.close();
	}

}
