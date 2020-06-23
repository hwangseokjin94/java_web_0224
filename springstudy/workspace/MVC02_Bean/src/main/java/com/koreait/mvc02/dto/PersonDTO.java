package com.koreait.mvc02.dto;

public class PersonDTO {

	private String name; 
	private int age;
	private ContactDTO contact;
	
	public PersonDTO() {}
	public PersonDTO(String name, int age, ContactDTO contact) {
		super();
		this.name = name;
		this.age = age;
		this.contact = contact;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ContactDTO getContact() {
		return contact;
	}
	public void setContact(ContactDTO contact) {
		this.contact = contact;
	}
	
}
