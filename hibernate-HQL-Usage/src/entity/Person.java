package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table( name = "PERSON_TABLE", catalog="hqltest")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id", unique=true)
	private Integer personId;
	
	@Column( name="person_name")
	private String personName;
	
	@Column( name = "person_last_name")
	private String personLastName;
	
	@Column( name = "person_address")
	private String personAddress;
	
	@Column( name = "person_salary")
	private Double personSalary;
	
	@Temporal(TemporalType.DATE)
	@Column( name= "person_birth_date")
	private Date personBirthDate;
	
	

	
	
	public Person() {
		
	}
	
	
	public Person(String name, String lastName, Double salary,Date bth, String address) {
		this.personName = name;
		this.personLastName = lastName;
		this.personAddress = address;
		this.personSalary = salary;
		this.personBirthDate = bth;
	}
	

	@Override
	public String toString() {
		return personId + " " + personName + " " + personLastName
				+ " " + personAddress + " " + personSalary + " "
				+ personBirthDate;
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
	public String getPersonLastName() {
		return personLastName;
	}
	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
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
	public Date getPersonBirthDate() {
		return personBirthDate;
	}
	public void setPersonBirthDate(Date personBirthDate) {
		this.personBirthDate = personBirthDate;
	}


	
	
}
