package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("oneToOneCon.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();

		// First Car and I10
		I10 grand = new I10();
		grand.setEngine("abc");
		grand.setModel("I10 Grand");
		grand.setSeats(4);
		session.save(grand);  // Save I10 first

		Car c1 = new Car();
		c1.setI10(grand);  // Associate saved I10 with Car
		session.save(c1);  // Now save Car

		// Second Car and I10
		I10 master = new I10();
		master.setEngine("tuba tuba");
		master.setModel("I10 Master");
		master.setSeats(7);
		session.save(master);  // Save I10 first

		Car c2 = new Car();
		c2.setI10(master);  // Associate saved I10 with Car
		session.save(c2);  // Now save Car

		ts.commit();  // Commit transaction
		
		//FETCH DATA
		Car fetchCar1 = session.get(Car.class, c1.getCarId());
		System.out.println(fetchCar1);
		System.out.println(fetchCar1.getI10().getEngine());
			
		session.close();
		factory.close();
	}
}
