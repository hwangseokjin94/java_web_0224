package com.koreait.ex2;

public class PersonMain {

	public static void main(String[] args) {
		
		Person p = new Person();
		
		p.gender = '남';
		p.age = 20;
		p.height = 180.5;
		p.name = "제임스";
		p.isAdult = p.age >= 20;
		
		System.out.println("성별 = " + p.gender);
		System.out.println("나이 = " + p.age);
		System.out.println("키 = " + p.height);
		System.out.println("이름 = " + p.name);
		System.out.println(p.isAdult ? "성인" : "미성년자");

	}

}
