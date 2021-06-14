package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Ders_TABLOSU", catalog="testogrenci")
public class Ders implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "DERS_ID", unique=true)
	private Integer dersId;
	
	@Column( name = "DERS_ADI")
	private String dersAdi;
	
	@Column( name ="DERS_KODU" )
	private String dersKodu;
	
	
	@ManyToMany(mappedBy = "dersler") //Ders sýnýfýndan oluþacak dersler, bu iliþkinin sahibi olduðunu bildiriyoruz mappedBy ile.
	private List<Ogrenci> ogrenciList = new ArrayList<>();//Dersi alan öðrencileri görmek istiyoruz bundan dolayý, List þeklinde yapýyoruz.

	
	public Ders() {
		
	}
	
	
	public Ders(String dersAdi, String dersKodu) {
		this.dersAdi = dersAdi;
		this.dersKodu = dersKodu;
		
	}

	
	
	// GETTER & SETTER
	public Integer getDersId() {
		return dersId;
	}

	public void setDersId(Integer dersId) {
		this.dersId = dersId;
	}

	public String getDersAdi() {
		return dersAdi;
	}

	public void setDersAdi(String dersAdi) {
		this.dersAdi = dersAdi;
	}

	public String getDersKodu() {
		return dersKodu;
	}

	public void setDersKodu(String dersKodu) {
		this.dersKodu = dersKodu;
	}

	public List<Ogrenci> getOgrenciList() {
		return ogrenciList;
	}

	public void setOgrenciList(List<Ogrenci> ogrenciList) {
		this.ogrenciList = ogrenciList;
	}
	
	
	
	
	
}
