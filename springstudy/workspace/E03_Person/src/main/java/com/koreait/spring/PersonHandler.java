package com.koreait.spring;

public class PersonHandler {

	// Field
		private Person person;
		
		// Constructor
		// 1. 디폴트
		public PersonHandler() {}
		// 2. 필드를 이용한 생성자
		public PersonHandler(Person person) {
			super();
			this.person = person;
		}
		
		// Method
		public void personInfo() {
			System.out.println("이름: " + person.getName());
			System.out.println("나이: " + person.getAge());
			System.out.println("성별: " + person.getGender());
			System.out.println("전화: " + person.getPhone());
		}
		public Person getPerson() {
			return person;
		}
		public void setPerson(Person person) {
			this.person = person;
		}
	
	
}
