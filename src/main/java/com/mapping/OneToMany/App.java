package com.mapping.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("oneToMany.xml").buildSessionFactory();
		Session session = factory.openSession();
	        Transaction transaction = session.beginTransaction();
//
	        // Create a question
	        Question question = new Question("What are the colors of the rainbow?");

	        // Create multiple answers
	        List<Answer> answers = new ArrayList<>();
	        answers.add(new Answer(question, "Red"));
	        answers.add(new Answer(question, "Orange"));
	        answers.add(new Answer(question, "Yellow"));

	        // Set answers to the question
	        question.setAnswers(answers);

	        // Save the question (which will also save the answers due to cascade)
	        session.save(question);

	        transaction.commit();

		Question q1 = session.get(Question.class, 1);
		System.out.println(q1.getId());     //if the type of LAZY it will print only required query and data
		//if the use of EAGER it will print all required query like join table or etc..
		
//		System.out.println(q1.getAnswers().get(0).getId() + " " + q1.getAnswers().get(0).getContent());

		// Fetching Answers directly using the question ID
//		Answer answers = session.get(Answer.class, 1);
//		System.out.println(answers);
//		System.out.println(answers.getQuestion().getId() + " " + answers.getQuestion().getContent());

		session.close();
		factory.close();

	}
}

//get() function humesha DB ko hit krta hai and
//load() srf proxy return krta hai.
//And agr hum lazy loading kre with the help
//of get() so DB hit hoga lekin vo srf question class ka data print krega and agar hum eager loading karenge with
//get() toh DB hit hoga but vo question class ki sari field ko print krega.
