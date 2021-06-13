package util;
import java.util.Date;

import org.hibernate.Session;

import entity.Urun;
import entity.UrunDetay;



public class MyAppTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		session.beginTransaction();
		
		// URUN
		Urun urun = new Urun();
		urun.setUrunAdi("Dell Laptop");
		urun.setUrunKodu("LAPTOP-1");
		
		
		// URUN DETAY
		UrunDetay urunDetay = new UrunDetay();
		urunDetay.setFirmaAdi("DELL");
		urunDetay.setFirmaAciklamasi("Dell Firmasi");
		urunDetay.setUrunAciklamasi("Dell Inspiron 3593 Intel Core i5 1035G1 16GB 1TB  256GB SSD MX230 Windows 10 Pro 15.6 FHD Taþýnabilir Bilgisayar");
		urunDetay.setListelenmeTarihi(new Date());
		
		
		//one-to-one  iliþki var.
		urun.setUrunDetay(urunDetay);
		urunDetay.setUrun(urun);
		
		session.save(urun);
		session.getTransaction().commit();
		
		System.out.println("Ürün baþarýlý þekilde kaydedildi...");

	}

}



