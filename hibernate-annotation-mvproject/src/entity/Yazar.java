package entity;

import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tbl_yazar", catalog="testdb")
public class Yazar implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "YAZAR_ID", unique = true)
	private Integer yazarId;
	@Column( name = "YAZAR_ADI")
	private String yazarAdi;
	@Column( name = "YAZAR_SOYADI")
	private String yazarSoyadi;
	
	public Yazar() {
		
	}
	
	public Yazar(String yazarAdi, String yazarSoyadi) {
		this.yazarAdi = yazarAdi;
		this.yazarSoyadi = yazarSoyadi;
	}
	
	
	public Integer getYazarId() {
		return yazarId;
	}
	public void setYazarId(Integer yazarId) {
		this.yazarId = yazarId;
	}
	public String getYazarAdi() {
		return yazarAdi;
	}
	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}
	public String getYazarSoyadi() {
		return yazarSoyadi;
	}
	public void setYazarSoyadi(String yazarSoyadi) {
		this.yazarSoyadi = yazarSoyadi;
	}


}
