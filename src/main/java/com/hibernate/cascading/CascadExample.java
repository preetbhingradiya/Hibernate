package com.hibernate.cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.OneToMany.Answer;
import com.mapping.OneToMany.Question;

public class CascadExample {
	
	public static void  main(String[] args) {
		SessionFactory factory = new Configuration().configure("oneToMany.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Question q1 = new Question();
		q1.setContent("What is cascading...");
		
		Answer a1 = new Answer(q1, "In hibernate it is important concept ");
		Answer a2 = new Answer(q1, "cascading is menas child object no need to save ");
		
		List<Answer> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		
		q1.setAnswers(list);
		
//		a1.setQuestion(q1);
//		a2.setQuestion(q1);
		
		session.save(q1);
		
		//THE USE CASCADE IN ENTITTY QUESTION CLASS NO NEDD IN OF RELATION CLASS TO SAVE IT
//		session.save(a1);
//		session.save(a2);
		
		tx.commit();
		
		session.close();
		factory.close();
	}

}
