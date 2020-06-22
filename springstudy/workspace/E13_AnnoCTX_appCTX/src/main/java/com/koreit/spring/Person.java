package com.koreit.spring;

import java.util.ArrayList;

public class Person {

	private String name;
	private ArrayList<String> hobbies;
	
	//Method
	public Person() {}
	public Person(String name, ArrayList<String> hobbies) {
		super();
		this.name = name;
		this.hobbies = hobbies;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	
}
