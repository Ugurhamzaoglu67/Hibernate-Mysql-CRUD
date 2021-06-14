package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entity.Person;

public class MainCrud {

	public static void main(String[] args) {
		
		addPerson();

	}
	
	
	// CREATE
	public static void addPerson() {
		try {
			Session session  = HibernateUtil.getSessionfactory().openSession();
			session.beginTransaction();
			
			Person person1 = new Person("Eylül","Sapmaz",new SimpleDateFormat("yyyy/MM/dd").parse("1996/03/03"),"Ýstanbul");
			Person person2 = new Person("Ahmet","Güven",new SimpleDateFormat("yyyy/MM/dd").parse("1995/03/03"),"Ýzmir");
			Person person3 = new Person("Seda","Bayindir",new SimpleDateFormat("yyyy/MM/dd").parse("1992/03/03"),"Ýstanbul");
			Person person4 = new Person("Osman","Sevdi",new SimpleDateFormat("yyyy/MM/dd").parse("1991/03/03"),"Zonguldak");
			
			session.save(person1);
			session.save(person2);
			session.save(person3);
			session.save(person4);
			
			session.getTransaction().commit();
			session.close();
			System.out.println("Ekleme iþlemi baþarýlý...");
			
		} catch (HibernateException e) {
		
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

}
