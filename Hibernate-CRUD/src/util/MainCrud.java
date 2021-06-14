package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entity.Person;

public class MainCrud {
	private static  Session session  = HibernateUtil.getSessionfactory().openSession();
	 
	public static void main(String[] args) {
		
		deletePerson(5);

	}
	
	
	// CREATE
	private static void addPerson() {
		try {
			Session session  = HibernateUtil.getSessionfactory().openSession();
			session.beginTransaction();
			
			Person person1 = new Person("Eyl�l","Sapmaz",5500.0,new SimpleDateFormat("yyyy/MM/dd").parse("1996/03/03"),"�stanbul");
			Person person2 = new Person("Ahmet","G�ven",6500.0,new SimpleDateFormat("yyyy/MM/dd").parse("1995/03/03"),"�zmir");
			Person person3 = new Person("Seda","Bayindir",7500.5,new SimpleDateFormat("yyyy/MM/dd").parse("1992/03/03"),"�stanbul");
			Person person4 = new Person("Osman","Sevdi",8500.30,new SimpleDateFormat("yyyy/MM/dd").parse("1991/03/03"),"Zonguldak");
			Person person5 = new Person("Hatice","G�zel P�nar",6500.30,new SimpleDateFormat("yyyy/MM/dd").parse("1991/03/03"),"London");
			Person person6 = new Person("Didem","Pembe",4500.30,new SimpleDateFormat("yyyy/MM/dd").parse("1991/03/03"),"Mu�la");
			
			
			
			session.save(person1);
			session.save(person2);
			session.save(person3);
			session.save(person4);
			session.save(person5);
			session.save(person6);
			
			session.getTransaction().commit();
			session.close();
			System.out.println("Ekleme i�lemi ba�ar�l�...");
			
		} catch (HibernateException e) {
		
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	
	// READ
	private static void readPerson() {
		
		session.beginTransaction();
		
		List<Person> personList = session.createQuery("FROM Person").list();
		
		for(Person p : personList) {
			System.out.println(p.getPersonId()+" "+p.getPersonName()+" "+p.getPersonLastname()+" "+
					p.getPersonSalary()+" "+p.getPersonBirthDay()+" "+p.getPersonAddress());
		}
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Okuma ba�ar�l�...");
		
	}


	// UPDATE
	private static void updatePerson(int personId, String newName, String newLastname, double newSalary, String newAdress) {
		try {
			session.beginTransaction();
			
			Person person  = session.get(Person.class, personId);
			
			person.setPersonName(newName);
			person.setPersonLastname(newLastname);
			person.setPersonSalary(newSalary);
			person.setPersonAddress(newAdress);
			
			session.update(person);
			session.getTransaction().commit();
			session.close();
			System.out.println("G�ncelleme ba�ar�l�....");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	// DELETE
	private static void deletePerson(int personId) {
		try {
			session.beginTransaction();
			
			Person person = session.get(Person.class, personId);
			session.delete(person);
			
			
			session.getTransaction().commit();
			session.close();
			System.out.println("Silme i�lemi ba�ar�l�..");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
