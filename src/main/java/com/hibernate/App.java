package com.hibernate;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        try {
            SessionFactory factory = new Configuration().configure("hibernetConfig.xml").buildSessionFactory();
            
            Employ emp = new Employ();
            emp.setName("Aakash");
            emp.setSalary(1299.12	);
            emp.setAddress("v1 navin res");
            
//            Certification certi = new Certification();
//            certi.setCourse("java");
//            certi.setDuration("11Month");
//            
//            
//            emp.setCerti(certi);
            System.out.println(emp);
            
            EmpDetails empD = new EmpDetails();
            empD.setQualification("BCA");
            empD.setStreet("katargam");
            empD.setCity("surat");
            empD.setProfile(false);
            empD.setX(12.00);
            empD.setAddDate(new Date());
            
            
            //Reading Image 
            try {
				FileInputStream file = new FileInputStream("src/main/java/image.png");
				byte[] data = new byte[file.available()];
				file.read(data);
				empD.setImage(data);
	
			} catch (IOException e) {
			    e.printStackTrace();
			}
            
            System.out.println(empD);
            
           Session session = factory.openSession();  //open new session
//           	--------------------------------
           
           Transaction tx = session.beginTransaction(); // transaction will start in store in tx
           session.save(emp);  
           
           	session.merge(empD);   //merge as -> save 
           tx.commit(); //commit the transaction
           
           
//                -------------------------------
           session.close();
            
            
            
            System.out.println(factory);
        } catch (HibernateException e) {
            System.err.println("Error creating SessionFactory: " + e.getMessage());
            e.printStackTrace();
        }
    } 
}


//sessionFactory is interface to use session object 
//configure is use of configure the xml file 
//biludsessionFacory function return the SessionFactory for build the session