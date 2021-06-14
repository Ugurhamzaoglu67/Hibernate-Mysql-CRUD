package entity;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table( name = "tbl_adres", catalog="testdb")
public class Adres implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column( name = "ADRES_ID", unique=true)
	private Integer adresId;
	
	@Column( name = "SOKAK_ADI")
	private String sokakAdi;
	
	@Column( name = "SEHIR_ADI")
	private String sehirAdi;
	
	@Column( name = "ULKE_ADI")
	private String ulkeAdi;
	
	@Column( name = "POSTA_KODU")
	private String postaKodu;
	
	@OneToOne
	private Personel personel;//Çift yönlü iliþki -> bidirectional iliþki. bundan dolayý 2 sýnýfada bunu belirtmek gerekir.
	
	
	
	
	public Adres() {
		
	}
	
	public Adres(String sokakAdi, String sehirAdi, String ulkeAdi, String postaKodu) {
		this.sokakAdi = sokakAdi;
		this.sehirAdi = sehirAdi;
		this.ulkeAdi = ulkeAdi;
		this.postaKodu = postaKodu;
	}
	
	
	// GETTER & SETTER
	public Personel getPersonel() {
		return personel;
	}
	public void setPersonel(Personel personel) {
		this.personel = personel;
	}
	
	public String getSokakAdi() {
		return sokakAdi;
	}
	public void setSokakAdi(String sokakAdi) {
		this.sokakAdi = sokakAdi;
	}
	public String getSehirAdi() {
		return sehirAdi;
	}
	public void setSehirAdi(String sehirAdi) {
		this.sehirAdi = sehirAdi;
	}
	public String getUlkeAdi() {
		return ulkeAdi;
	}
	public void setUlkeAdi(String ulkeAdi) {
		this.ulkeAdi = ulkeAdi;
	}
	public String getPostaKodu() {
		return postaKodu;
	}
	public void setPostaKodu(String postaKodu) {
		this.postaKodu = postaKodu;
	}
	
	
	
}
