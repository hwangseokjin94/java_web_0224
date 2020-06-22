package com.koreait.spring;

public class PersonHandler {
	//Field
	private Person person;
	
	//Construcor
	public PersonHandler() {}
	public PersonHandler(Person person) {
		super();
		this.person = person;
	}
	
	//method
	public void personInfo() {
		System.out.println("이름 : "+person.getName());
		System.out.println("나이 : "+person.getAge());	
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
