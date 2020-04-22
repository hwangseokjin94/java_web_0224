package com.koreait.ex2;

public class PersonMain {

	public static void main(String[] args) {
		
		Person man = new Person("제임스", "951212-5234567");
		Person woman = new Person("앨리스", "051212-8123456");
		
		man.printPerson();
		woman.printPerson();

	}

}
