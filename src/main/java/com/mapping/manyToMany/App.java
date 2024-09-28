package com.mapping.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.OneToMany.Answer;
import com.mapping.OneToMany.Question;

public class App {

	public static void main(String[] args) {
		
		  SessionFactory factory = new Configuration().configure("manyToMany.xml").buildSessionFactory();
	        Session session = factory.openSession();
	        Transaction transaction = session.beginTransaction();
	        
	        //ADD MULTIPAL EMP
	        Employ empRam = new Employ();
	        Employ empAakash = new Employ();
	        
	        empRam.setEmp_name("Ram");
	        
	        empAakash.setEmp_name("Aakash");
	        
	        //ADD MULTIPAL PROJECT
	        Project proLibrary = new Project();
	        Project proHotel = new Project();
	        
	        proLibrary.setProject_name("Library management system");
	        
	        proHotel.setProject_name("Hotel system");
	        
	        
	        //EMP ADD IN LIST
	        List<Employ> listOfEmp = new ArrayList<>();
	        listOfEmp.add(empAakash);
	        listOfEmp.add(empRam);
	        
	        //PROJECT ADD IN LIST
	        List<Project> listOfProject = new ArrayList<>();
	        listOfProject.add(proLibrary);
	        listOfProject.add(proHotel);
	        
	        
	        //Here employe_project table one employe access multipal project
	        //And project_employe table one project assign multipal employe
	        empRam.setProject(listOfProject);
	        proHotel.setEmploy(listOfEmp);
	        
	        empAakash.setProject(listOfProject);
	        proLibrary.setEmploy(listOfEmp);;
	        
	        
	        session.save(empRam);
	        session.save(empAakash);
	        session.save(proLibrary);
	        session.save(proHotel);	        

	        transaction.commit();

	        
	        session.close();
	        factory.close();

	}

	
}
