package com.koreait.ex2;

class Person {

	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;

	}

	//
	void printPerson() {
		System.out.println(" 이름   " + name + "나이  ; " + age + " 살");
	}
}

class Student extends Person {
	String school;

	Student(String school, String name, int age) {
		super(name, age);
		this.school = school;
	}

	void printStudent() {
		printPerson();
		System.out.println("학교 " + school);
	}

}

class Worker extends Person {
	String job;

	Worker(String job, String name, int age) {
		super(name , age);
		this.job  = job;
		
	}
	
	void printWorker() {
		printPerson();
		System.out.println("직업 "+ job);
	}
	
	
	
	
	
	
}

public class Ex02_Person {
	public static void main(String[] args) {
		Student student  = new Student("이대", "앨리스", 21);
		Worker worker = new Worker("삼성", "사만다"	, 25);
		
		
		student .printStudent();
		worker.printWorker();
				
	}
}
