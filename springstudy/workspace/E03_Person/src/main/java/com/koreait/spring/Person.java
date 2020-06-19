package com.koreait.spring;

public class Person {

	// Field (Property)
	private String name ;
	private int age ;
	private char gender;
	private String phone;
	
	//Constructor
	//1.디폴트
	
	public Person() {}
	//2.필드를 이용한 생성자
	public Person(String name, int age, char gender, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}
	
	//Method
	//Getters and Setters
		
	
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
