package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "tbl_kitap", catalog="testdb")
public class Kitap implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name = "KITAP_ID", unique = true)
	private Integer kitapId;
	
	@Column(name = "KITAP_ADI")
	private String kitapAdi;
	
	@Column(name = "KITAP_ACIKLAMASI")
	private String kitapAciklamasi;
	
	@Temporal(TemporalType.DATE)
	@Column( name = "YAYINLANMA_TARIHI")
	private Date yayinlanmaTarihi;
	
	@JoinColumn(name = "YAZAR_ID")  //Karþý sýnýfa denk gelen primary key'i alýyoruz.
	@OneToOne(cascade = CascadeType.ALL)
	private Yazar yazar; // Relation

	
	public Kitap() {
		
	}
	
	public Kitap(String kitapAdi, String kitapAciklamasi, Date yayin) {
		this.kitapAdi = kitapAdi;
		this.kitapAciklamasi = kitapAciklamasi;
		this.yayinlanmaTarihi = yayin;
	}
	
	
	
	public Integer getKitapId() {
		return kitapId;
	}

	public void setKitapId(Integer kitapId) {
		this.kitapId = kitapId;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getKitapAciklamasi() {
		return kitapAciklamasi;
	}

	public void setKitapAciklamasi(String kitapAciklamasi) {
		this.kitapAciklamasi = kitapAciklamasi;
	}

	public Date getYayinlanmaTarihi() {
		return yayinlanmaTarihi;
	}

	public void setYayinlanmaTarihi(Date yayinlanmaTarihi) {
		this.yayinlanmaTarihi = yayinlanmaTarihi;
	}

	public Yazar getYazar() {
		return yazar;
	}

	public void setYazar(Yazar yazar) {
		this.yazar = yazar;
	}	
}
