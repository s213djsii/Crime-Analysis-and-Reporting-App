package com.model;

import java.time.LocalDate;

import java.util.Objects;

public class Victim {
	
	private int victimId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String gender;
	private String contactNumber;
	private int incidentId;

	
	public Victim() {  }


	public Victim(String firstName, String lastName, LocalDate dob, String gender, String contactNumber, int incidentId) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.incidentId = incidentId;
	}



	public Victim(int victimId, String firstName, String lastName, LocalDate dob, String gender, String contactNumber,
			int incidentId) {
		
		this.victimId = victimId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.incidentId = incidentId;
	}


	public int getVictimId() {
		return victimId;
	}


	public void setVictimId(int victimId) {
		this.victimId = victimId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, dob, firstName, gender, incidentId, lastName, victimId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Victim other = (Victim) obj;
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(dob, other.dob)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& incidentId == other.incidentId && Objects.equals(lastName, other.lastName)
				&& victimId == other.victimId;
	}


	public int getIncidentId() {
		return incidentId;
	}


	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}


	@Override
	public String toString() {
		return "Victim [victimId=" + victimId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", incidentId=" + incidentId + "]";
	}
	
	

}
