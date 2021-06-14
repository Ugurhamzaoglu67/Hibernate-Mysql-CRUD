package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="PERSON_TABLE", catalog="crudogrenci")
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Person_id", unique=true)
	private Integer personId;
	
	@Column( name = "Person_name")
	private String personName;
	
	@Column( name="Person_last_name")
	private String personLastname;
	
	@Column( name = "Person_salary")
	private Double personSalary;
	
	@Temporal(TemporalType.DATE)
	@Column( name = "Person_birthday")
	private Date personBirthDay;
	
	@Column( name = "Prson_address")
	private String personAddress;
	
	
	
	public Person() {
		
	}
	
	public Person(String personName, String personLastname,Double personSalary ,Date personBirthDay, String personAddress) {
	
		this.personName = personName;
		this.personLastname = personLastname;
		this.personSalary = personSalary;
		this.personBirthDay = personBirthDay;
		this.personAddress = personAddress;
	}



	// GETTER & SETTER
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonLastname() {
		return personLastname;
	}
	public void setPersonLastname(String personLastname) {
		this.personLastname = personLastname;
	}
	public Date getPersonBirthDay() {
		return personBirthDay;
	}
	public void setPersonBirthDay(Date personBirthDay) {
		this.personBirthDay = personBirthDay;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public Double getPersonSalary() {
		return personSalary;
	}

	public void setPersonSalary(Double personSalary) {
		this.personSalary = personSalary;
	}
	
	
	
	

}
