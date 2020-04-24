package com.koerait.hash;

class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}
}

public class Ex01_hashCode {
	public static void main(String[] args) {
		Person p = new Person("제임스");
		System.out.println("객체 p의 출력 :"+ p);
		System.out.println(p.hashCode());
		System.out.printf("객체 p의 참조(주소) :%x",p.hashCode());
		
		System.out.println();
		System.out.println("----------------------------------");
		
		Person q = new Person("앨리스");
		System.out.println("객체 p의 출력 :"+ q);
		System.out.println(q.hashCode());
		System.out.printf("객체 q의 참조(주소) :%x",q.hashCode());
		
		//자바입장 :객체 p,q는 다른객체이다. (다른곳에 저장되어 있으므로)
		//Set에 객체 p,q가 모두 저장될 수 있다.
		
		//사용자 입장 : 객체 p,q는 같은 객체이다.(이름이 같으니까)
		//Set 에 객체 p,q가 중복 저장되기 않기를 기대한다.
		
		
	}
}
