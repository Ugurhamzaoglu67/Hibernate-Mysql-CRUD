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
			
			// K�TAP
			Kitap kitap = new Kitap();
			kitap.setKitapAdi("Harry Potter ve Ate� Kadehi");
			kitap.setKitapAciklamasi("Harry, yaz tatilinin bir k�sm�n� Dursley'lerde ge�irdikten sonra arkada�� Ron'un daveti �zerine yaz tatilinin geri kalan�n� Kovuk'ta ge�irmeye karar verir. "
					+ "Kovuk'ta ge�irdi�i birka� mutlu g�n�n ard�ndan Weasley ailesi ile");
			kitap.setYayinlanmaTarihi(new Date("7/7/2000"));
	
			kitap.setYazar(yazar);
			
			
			session.save(kitap);
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Kay�t i�lemi tamamland�...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}







