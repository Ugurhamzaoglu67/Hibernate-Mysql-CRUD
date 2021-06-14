package util;

import java.util.Date;

import org.hibernate.Session;

import entity.Kitap;
import entity.Yazar;

public class BookTest {

	public static void main(String[] args) {
		
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			// YAZAR
			Yazar yazar = new Yazar("J. Kathleen","Rowling");
			
			// KÝTAP
			Kitap kitap = new Kitap();
			kitap.setKitapAdi("Harry Potter ve Ateþ Kadehi");
			kitap.setKitapAciklamasi("Harry, yaz tatilinin bir kýsmýný Dursley'lerde geçirdikten sonra arkadaþý Ron'un daveti üzerine yaz tatilinin geri kalanýný Kovuk'ta geçirmeye karar verir. "
					+ "Kovuk'ta geçirdiði birkaç mutlu günün ardýndan Weasley ailesi ile");
			kitap.setYayinlanmaTarihi(new Date("7/7/2000"));
	
			kitap.setYazar(yazar);
			
			
			session.save(kitap);
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Kayýt iþlemi tamamlandý...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}







