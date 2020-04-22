package com.koreait.ex;

// 데이터클래스 Person
class Person {
	
	// Field
	String name;
	int age;
	
	// Constructor
	Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person(String name, int age) 생성자 호출");
	}
	
	// Method
	void printPerson() {
		System.out.println("이름 : " + name + ", 나이 : " + age + "살");
	}
	
}

public class Ex01_Person {

	public static void main(String[] args) {
		
		// Person 3개 객체를 저장할 수 있는 people 배열 선언
		Person[] people = new Person[3];  // Person 생성자는 호출되지 않는다.
		
		// 3개 Person이 생성되었습니까? No.
		
		// 아래와 같은 작업을 통해서 3개 Person을 생성한다.
		// people[0] = new Person("name", age);
		// people[1] = new Person("name", age);
		// people[2] = new Person("name", age);
		String[] name = {"제임스", "앨리스", "데이빗"};
		int[] age = {20, 25, 30};
		
		// 1. 3개 Person 객체 생성 후 배열에 저장
		for (int i = 0; i < people.length; i++) {
			people[i] = new Person(name[i], age[i]);
		}
		
		// 2. 출력
		for (int i = 0; i < people.length; i++) {
			people[i].printPerson();
		}

	}

}