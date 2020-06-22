package com.koreait.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoCTX.class);
		
		Person p1 = ctx.getBean("person1", Person.class);
		System.out.println("이름: " + p1.getName());
		System.out.println("취미: " + p1.getHobbies());
		
		Person p2 = ctx.getBean("person2", Person.class);
		System.out.println("이름: " + p2.getName());
		System.out.println("취미: " + p2.getHobbies());
		
		ctx.close();
		
	}

}
