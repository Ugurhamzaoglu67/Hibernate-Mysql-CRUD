package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.JpaDmlCriteria;

import com.ibm.icu.impl.locale.XCldrStub.Predicate;
import com.sun.xml.bind.v2.runtime.reflect.ListIterator;

import entity.Person;



public class MainTest {
	

	public static void main(String[] args) {
		
	
		
	}
	
	
		// CREATE
		private static void addPerson() {
			try {
				Session session  = HibernateUtil.getSessionfactory().openSession();
				session.beginTransaction();
				
				Person person1 = new Person("Eylül","Sapmaz",5500.0,new SimpleDateFormat("yyyy/MM/dd").parse("1996/03/03"),"istanbul");
				Person person2 = new Person("Ahmet","Güven",6500.0,new SimpleDateFormat("yyyy/MM/dd").parse("1995/03/03"),"izmir");
				Person person3 = new Person("Seda","Bayindir",7500.5,new SimpleDateFormat("yyyy/MM/dd").parse("1992/03/03"),"istanbul");
				Person person4 = new Person("Osman","Sevdi",8500.30,new SimpleDateFormat("yyyy/MM/dd").parse("1991/03/03"),"Zonguldak");
				Person person5 = new Person("Hatice","Güzel Pinar",6500.30,new SimpleDateFormat("yyyy/MM/dd").parse("1991/03/03"),"London");
				Person person6 = new Person("Didem","Pembe",4500.30,new SimpleDateFormat("yyyy/MM/dd").parse("1991/03/03"),"Mugla");
				
				
				
				session.save(person1);
				session.save(person2);
				session.save(person3);
				session.save(person4);
				session.save(person5);
				session.save(person6);
				
				session.getTransaction().commit();
				session.close();
				System.out.println("Ekleme basarili...");
				
			} catch (HibernateException e) {
			
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		// FROM KULLANIMI (Query)
		private static List myList() {
		List result = null;
		
		try {
			Session session = HibernateUtil.getSessionfactory().openSession();
			session.beginTransaction();
			
			Query myQuery  = session.createQuery("FROM Person");		
			result = myQuery.list();
			
			Iterator<Person> iterator = result.iterator();
			
			while(iterator.hasNext()) {
				Person person =(Person)iterator.next();
				System.out.println(person);
				
			}
			
			session.getTransaction().commit();
			session.close();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}

		
		// AS KULLANIMI (Query)
		private static List asUsage() {
			
			List list = null;
			
			try {
				
				Session session = HibernateUtil.getSessionfactory().openSession();		
				session.beginTransaction();									
				
				Query myQuery =  session.createQuery("FROM Person AS P");
				list = myQuery.list(); // Sorgu sonuçlarını Liste olarak döndürür. Birden fazla sonuç Object[] olarak döndürülür.
				
				Iterator iterator = list.iterator();
				
				while(iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				
				
				session.getTransaction().commit();
				session.close();
				
				
			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			}
			
			
			return list;
			
		}
		
		
		//select KULLANIMI ( CRITERIA API )
		private static List<Person> selectUsage() {
			
			List<Person> mylist = null;
			
			try {
				Session session = HibernateUtil.getSessionfactory().openSession();
				session.beginTransaction();
			
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
				
				Root<Person> root = criteria.from(Person.class);
				criteria.select(root); //Üstteki tanımladığımız sınıfı sorgulama.
				
				
				mylist = session.createQuery(criteria).getResultList();
				
				for(Person p : mylist) {
					System.out.println(p);
				}
				
				session.getTransaction().commit();
				session.close();
				
			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			}
			
			return mylist;
		}
		
		
		//greater than KULLANIMI ( CRITERIA API )
		private static List<Person> greaterThanUsage() {
			List<Person> mylist = null;
			
			try {
				Session session = HibernateUtil.getSessionfactory().openSession();
				session.beginTransaction();
				
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
				Root<Person> root = criteria.from(Person.class);
				criteria.select(root).where(builder.gt(root.get("personSalary"), 5000.0));
				
				mylist = session.createQuery(criteria).getResultList();
				
				for(Person p : mylist) {
					System.out.println(p);
				}
				
				session.getTransaction().commit();
				session.close();
						
				
			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			}
			
			return mylist;
			
		}
		
		
}





















