package com.koreait.ex;

//
class Person {
	String name;
	int age;

	// 생성자 컨스트럭트
	Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person(String name ,int age)생성자 호출");
	}

	// 메소드
	void printPerson() {
		System.out.println("이름 : " + name + ", 나이 :" + age + "살");
	}

}// per

public class Ex01_Person {

	public static void main(String[] args) {
		// Person 3개 객체를 저장할수있는 people배열선언

		Person[] people = new Person[3]; // Person 생성자는 호출되지않는다.
//		int[] arr = new int[3];정수세개배열 오브젝트라고해서 문법이다르지가 않다.
		// 3개 person 이 생성되었습니까? NO
		// 아래와같은 작업을 통해서 3개의 Person을생성한다
		// people [0] =new Person("name","age")
		// people [1] =new Person("name","age")
		// people [2] =new Person("name","age")
		String[] name = { "제임스", "엘리스", "데이빗" };
		int[] age = { 20, 25, 30 };
		// 1. 3개 Person객체 생성후 배열에 저장
		for (int i = 0; i < people.length; i++) {
			people[i] = new Person(name[i], age[i]);
		}
		// 2.출력
		for (int i = 0; i < people.length; i++) {
			people[i].printPerson();

		}

	}

}
