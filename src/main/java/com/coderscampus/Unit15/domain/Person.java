package com.coderscampus.Unit15.domain;

public class Person {
	
	private String firstName;
	private String lastName;
	public Integer ID;
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
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer id) {
		this.ID = id;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", ID=" + ID + "]";
	}
	
	

}
