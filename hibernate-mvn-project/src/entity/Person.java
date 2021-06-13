package entity;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer personId;
	private String personName;
	private String personLastname;
	private String personAddress;
	private Date personDateOfBirth;
	
	// CONSTRUCTOR 1
	public Person() {
		
	}
	
	
	// CONSTRUCTOR 2
	public Person(String personName, String personLastname, String personAddress, Date dob) {
		
		this.personName = personName;
		this.personLastname = personLastname;
		this.personAddress = personAddress;
		this.personDateOfBirth = dob;
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
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	public Date getPersonDateOfBirth() {
		return personDateOfBirth;
	}
	public void setPersonDateOfBirth(Date personDateOfBirth) {
		this.personDateOfBirth = personDateOfBirth;
	}
	
	
	

}
