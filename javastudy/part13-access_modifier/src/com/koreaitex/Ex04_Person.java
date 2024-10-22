package com.koreaitex;

class Person {
	private String name;
	private int age;
	private boolean isAdult;

	// setter

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}

	// getter

	public String getName() {
		return name;
	}

	public int getAge() {

		return age;
	}

	public boolean isAdult() {

		if (age > 20) {
			this.isAdult = true;
		} else {
			this.isAdult = false;
		}

		return isAdult;
	}

}

public class Ex04_Person {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("제임슨");
		person.setAge(10);

		System.out.println("이름 : " + person.getName());
		System.out.println("나임 :" + person.getAge());
		System.out.println(person.isAdult() ? "성인" : "미성년자");

	}
}
