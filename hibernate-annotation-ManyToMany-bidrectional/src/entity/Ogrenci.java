package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table( name = "Ogrenci_TABLOSU", catalog="testogrenci")
public class Ogrenci  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "OGRENCI_ID", unique=true)
	private Integer ogrenciId;
	
	@Column( name = "OGRENCI_ADI")
	private String ogrenciAdi;
	
	@Column( name = "Ogrenci_SOYADI")
	private String ogrenciSoyadi;
	
	@Temporal(TemporalType.DATE)
	@Column( name = "Ogrenci_DOGUM_T")
	private Date ogrenciDogumTarihi;
	
	@ManyToMany( cascade = CascadeType.ALL) 							//ManyToMany söz konusu ise, Ortak TABLODA Birleþtiriyoruz. ORTAK TABLODADA -> Baðlý olan 2 sýnýfýn -> KEY'LERÝNÝ ORAYA EKLÝYORUZ.
	@JoinTable( name = "Ogrenci_Ders_TABLOSU", 							// YENÝ TABLOMUZUN ADI
				joinColumns = {@JoinColumn( name = "OGRENCI_ID")},
				inverseJoinColumns = {@JoinColumn( name = "DERS_ID")}) 	// BU iki sýnýf, oluþturacaðým bu Tabloda birleþsin dedik.
	private List<Ders> dersler = new ArrayList<>(); 					//Ogrencilerin derslerini görmek için list lazým. ***Not -> dersler ManyToMany yaptýðýmýz Ders classýndaki iliþkinin sahibi -> mappedBy="dersler"

	
	public Ogrenci() {
		
	}
	
	public Ogrenci(String ogrenciAdi, String ogrenciSoyadi, Date ogrenciDogumTarihi) {
		this.ogrenciAdi = ogrenciAdi;
		this.ogrenciSoyadi = ogrenciSoyadi;
		this.ogrenciDogumTarihi = ogrenciDogumTarihi;
	
	}


	// GETTER & SETTER
	public Integer getOgrenciId() {
		return ogrenciId;
	}


	public void setOgrenciId(Integer ogrenciId) {
		this.ogrenciId = ogrenciId;
	}


	public String getOgrenciAdi() {
		return ogrenciAdi;
	}


	public void setOgrenciAdi(String ogrenciAdi) {
		this.ogrenciAdi = ogrenciAdi;
	}


	public String getOgrenciSoyadi() {
		return ogrenciSoyadi;
	}


	public void setOgrenciSoyadi(String ogrenciSoyadi) {
		this.ogrenciSoyadi = ogrenciSoyadi;
	}


	public Date getOgrenciDogumTarihi() {
		return ogrenciDogumTarihi;
	}


	public void setOgrenciDogumTarihi(Date ogrenciDogumTarihi) {
		this.ogrenciDogumTarihi = ogrenciDogumTarihi;
	}


	public List<Ders> getDersler() {
		return dersler;
	}


	public void setDersler(List<Ders> dersler) {
		this.dersler = dersler;
	}
	
	
	
}
