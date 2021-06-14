package util;

import java.text.SimpleDateFormat;

import org.hibernate.Session;

import entity.Ders;
import entity.Ogrenci;

public class OgrenciTest {

	public static void main(String[] args) {
		
		

		try {
			
			Session session = HibernateUtil.getSessionfactory().openSession();
			session.beginTransaction();
			
			Ogrenci ayse = new Ogrenci("Ayþe","Yýlmaz",new SimpleDateFormat("yyyy/MM/dd").parse("1994/03/03"));
			Ogrenci selin  =  new Ogrenci("Selin","Yýlmaz",new SimpleDateFormat("yyyy/MM/dd").parse("1993/03/03"));
		
			Ders matematik = new Ders("Matematik","132213");
			Ders fizik = new Ders("fizik","1324213");
			Ders kimya = new Ders("kimya","1324713");
			Ders bio = new Ders("bio","1122213");
			Ders edebiyat = new Ders("edebiyat","82313");
			
			ayse.getDersler().add(matematik);
			ayse.getDersler().add(fizik);
			ayse.getDersler().add(kimya);
			
			selin.getDersler().add(matematik);
			selin.getDersler().add(bio);
			selin.getDersler().add(edebiyat);
			
			session.save(ayse);
			session.save(selin);
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Kayýt baþarýlý...");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		


}
}
