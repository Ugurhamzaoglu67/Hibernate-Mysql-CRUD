package entity;

import java.io.Serializable;

public class Urun implements Serializable{


	private static final long serialVersionUID = 1L;

	
	private Integer urunId;
	private String urunKodu;
	private String urunAdi;
	private UrunDetay urunDetay; // One-To-One   için
	
	public Urun() {
		
	}
	
	public Urun(String urunKodu, String urunAdi) {
		this.urunKodu = urunKodu;
		this.urunAdi = urunAdi;
	}
	
	
	public Integer getUrunId() {
		return urunId;
	}
	public void setUrunId(Integer urunId) {
		this.urunId = urunId;
	}
	public String getUrunKodu() {
		return urunKodu;
	}
	public void setUrunKodu(String urunKodu) {
		this.urunKodu = urunKodu;
	}
	public String getUrunAdi() {
		return urunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	public UrunDetay getUrunDetay() {
		return urunDetay;
	}
	public void setUrunDetay(UrunDetay urunDetay) {
		this.urunDetay = urunDetay;
	}
	
	
	
}
