package entity;

import java.io.Serializable;
import java.util.Date;

public class UrunDetay implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer urunDetayId;
	private String urunAciklamasi;
	private String firmaAdi;
	private String firmaAciklamasi;
	private Date listelenmeTarihi;
	private Urun urun; // One-To-One   için
	
	
	public UrunDetay() {
		
	}
	
	
	
	
	
	public UrunDetay(String urunAciklamasi, String firmaAdi, String firmaAciklamasi,
			Date listelenmeTarihi, Urun urun) {
		
		this.urunAciklamasi = urunAciklamasi;
		this.firmaAdi = firmaAdi;
		this.firmaAciklamasi = firmaAciklamasi;
		this.listelenmeTarihi = listelenmeTarihi;
		this.urun = urun;
	}





	//GETTER & SETTER
	public Urun getUrun() {
		return urun;
	}
	public void setUrun(Urun urun) {
		this.urun = urun;
	}
	public Integer getUrunDetayId() {
		return urunDetayId;
	}
	public void setUrunDetayId(Integer urunDetayId) {
		this.urunDetayId = urunDetayId;
	}
	public String getUrunAciklamasi() {
		return urunAciklamasi;
	}
	public void setUrunAciklamasi(String urunAciklamasi) {
		this.urunAciklamasi = urunAciklamasi;
	}
	public String getFirmaAdi() {
		return firmaAdi;
	}
	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}
	public String getFirmaAciklamasi() {
		return firmaAciklamasi;
	}
	public void setFirmaAciklamasi(String firmaAciklamasi) {
		this.firmaAciklamasi = firmaAciklamasi;
	}
	public Date getListelenmeTarihi() {
		return listelenmeTarihi;
	}
	public void setListelenmeTarihi(Date listelenmeTarihi) {
		this.listelenmeTarihi = listelenmeTarihi;
	}
	
	
	
	
}
