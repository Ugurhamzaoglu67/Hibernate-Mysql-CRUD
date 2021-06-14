package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entity.Adres;
import entity.Personel;

public class PersonelTest {

	public static void main(String[] args) {
	
	
			
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				
				Personel personel = new Personel("Elif","Y�lmaz",new SimpleDateFormat("yyyy/MM/dd").parse("1994/03/03"));
				
				Adres adres = new Adres("elm Soka��","Los Angeles","California / USA","90002");
				
				personel.setAdres(adres); // Personelin -> adresi 
				adres.setPersonel(personel); // Adresinde -> personeli 
				
				
				session.save(personel); // ili�kinin sahibi save ediyoruz.
				session.getTransaction().commit();
				session.close();
				
				System.out.println("Kay�t ba�ar�yla olu�turuldu....");
				
			} catch (HibernateException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
			
			
		
		

	}

}
