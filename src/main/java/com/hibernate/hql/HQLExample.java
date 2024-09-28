package com.hibernate.hql;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Employ;

public class HQLExample {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernetConfig.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		String hqlQuery = "from Employ";   //from work like select * from and Student is class name of entity not table name
		
		Query<Employ> q = session.createQuery(hqlQuery, Employ.class);
		
		List<Employ> list = q.list();
		
		System.out.println(list);
		
		//FIND QUERY WITH DAYNAMIC PARAMETER
		System.out.println("----------------------------------------------");
		
		String query = "from Employ where name = :x and id =:y";  //name as varible of Employe class
		Query<Employ> findQuery = session.createQuery(query, Employ.class);
			
		findQuery.setParameter("x", "Aakash");
		UUID uuid = UUID.fromString("f2870e06-d8bc-42cf-8edd-c1bb0542c1ad");
		findQuery.setParameter("y", uuid);
		
		List<Employ> list2 = findQuery.list();
		System.out.println(list2);
		
		
		
		System.out.println("--------------------------DELETE----------------------------------");
		

//		Query<Employ> deleteQuery = session.createQuery("delete Employ where id = :x");
//		UUID deleteId = UUID.fromString("0a9ef027-e70d-409e-84b3-ab65351c6dcb");
//		deleteQuery.setParameter("x", deleteId);
//		deleteQuery.executeUpdate();
		
		
		System.out.println("----------------------UPDATE--------------------------------");
		Query<Employ> updateQuery =  session.createQuery("update Employ set name= :a, salary = :b, address = :c where id =:d", Employ.class);
		UUID updateId = UUID.fromString("f2870e06-d8bc-42cf-8edd-c1bb0542c1ad");
		updateQuery.setParameter("a", "jaggu");
		updateQuery.setParameter("b", 1234.23);
		updateQuery.setParameter("c", "b1 new city");
		updateQuery.setParameter("d", updateId);
		int row = updateQuery.executeUpdate();
		System.out.println(row);
		
		
		
		transaction.commit();
		
		session.close();
		factory.close();
	}
}
