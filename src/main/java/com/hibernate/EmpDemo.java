package com.hibernate;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpDemo {

	public static void main(String[] args) {

		Employ emp = new Employ();
		emp.setName("Aakash");
		emp.setSalary(1299.12);
		emp.setAddress("v1 navin res");

		Certification certi = new Certification();
		certi.setCourse("Node.js");
		certi.setDuration("12Month");

		emp.setCerti(certi);

		System.out.println(emp);

		SessionFactory facotry = new Configuration().configure("hibernetConfig.xml").buildSessionFactory();

		Session session = facotry.openSession();

//		  Employ emp1 =session.get(Employ.class, UUID.fromString("f2870e06-d8bc-42cf-8edd-c1bb0542c1ad"));
//		  System.out.println(emp1);
		Transaction ts = session.beginTransaction();

		session.merge(emp);
		ts.commit();

		session.close();
		facotry.close();
	}

}
