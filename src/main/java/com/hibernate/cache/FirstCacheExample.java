package com.hibernate.cache;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mapping.OneToMany.Answer;

//Using createQuery() s HQL Query so it not store object in cache

public class FirstCacheExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("oneToMany.xml").buildSessionFactory();

		Session session = factory.openSession();
		
		String query = "from Answer where id =:x";
		
//		Query<Answer> a1 = session.createQuery(query);
//		a1.setParameter("x", 1);
//		List<Answer> answer1 = a1.list();
		
//		System.out.println(answer1);
		
		Answer a1 = session.get(Answer.class, 1);
		System.out.println(a1);

		// if the first time fire query that time hibernate store object in cache
		// memeory in future this object related found so not fire same query in db just
		// return cache object
		
		System.out.println("Work Something...");
		
		Answer a2 = session.get(Answer.class, 1);
		System.out.println(a2);
		
//		Query<Answer> a2 = session.createQuery(query);
//		a2.setParameter("x", 1);
//		List<Answer> answer2 = a2.list();
//		System.out.println(answer2);
		
		

		
		session.close();
		
		
	}

}
