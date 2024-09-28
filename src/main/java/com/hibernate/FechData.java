package com.hibernate;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FechData {
	public static void main(String[] args) {
		
	   SessionFactory factory = new Configuration().configure("hibernetConfig.xml").buildSessionFactory();
	   
	   Session session = factory.openSession();
	   
	   //get data
	   Employ emp =  session.get(Employ.class, UUID.fromString("23eac31a-fa97-457b-8d2b-a5e347f132e3"));
	   
	   System.out.println(emp);
	   
	   session.close();
	   factory.close();
	}
}
