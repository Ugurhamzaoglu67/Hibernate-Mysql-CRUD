package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name = "tbl_personel", catalog="testdb")
public class Personel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PERSONEL_ID", unique=true)
	private Integer personelId;
	
	@Column ( name = "PERSONEL_ADI")
	private String personelName;
	
	@Column ( name = "PERSONEL_SOYADI")
	private String personelLastName;
	
	@Temporal(TemporalType.DATE)
	@Column ( name = "PERSONEL_DOGUM_T")
	private Date personelBirthDay;
	
	
	@OneToOne(mappedBy = "personel", cascade = CascadeType.ALL)  // mappedBy -> ile Ýliþkinin sahibini belirtiyoruz.
	private Adres adres;//Çift yönlü iliþki -> bidirectional iliþki. bundan dolayý 2 sýnýfada bunu belirtmek gerekir.
	
	
	
	public Personel() {
		
	}
	
	public Personel(String name, String lastName, Date birthDay) {
		this.personelName = name;
		this.personelLastName = lastName;
		this.personelBirthDay = birthDay;
	}
	
	
	// GETTER & SETTER
	public Integer getPersonelId() {
		return personelId;
	}
	public void setPersonelId(Integer personelId) {
		this.personelId = personelId;
	}
	public String getPersonelName() {
		return personelName;
	}
	public void setPersonelName(String personelName) {
		this.personelName = personelName;
	}
	public String getPersonelLastName() {
		return personelLastName;
	}
	public void setPersonelLastName(String personelLastName) {
		this.personelLastName = personelLastName;
	}
	public Date getPersonelBirthDay() {
		return personelBirthDay;
	}
	public void setPersonelBirthDay(Date personelBirthDay) {
		this.personelBirthDay = personelBirthDay;
	}
	
	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

				
		 
}
