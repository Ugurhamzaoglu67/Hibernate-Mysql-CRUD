package util;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Person;

public class TestApp {
	
	
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
	
			try {
				
				sessionFactory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
				
			} catch (Throwable e) {
				System.out.println("Baðlantý hatasý! "+e);
				throw new ExceptionInInitializerError();
			}
			
			TestApp testApp = new TestApp();
			
			testApp.addPerson("Ugur", "Hmz", "Zonguldak / Turkey", new Date("26/04/1994"));
			
	}
	
	
	// ADD PERSON
	private void addPerson(String name, String lastName, String address, Date dob) {
		
		Session session  = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			Person person = new Person(name,lastName, address, dob);
			session.save(person);
			tx.commit(); //Transaction commit
			
			
		} catch (HibernateException e) {
			
			if(tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}	
		
		finally {
			session.close();
		}
	}
}





















