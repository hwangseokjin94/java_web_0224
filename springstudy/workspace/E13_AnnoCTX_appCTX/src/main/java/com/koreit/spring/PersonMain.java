package com.koreit.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =  new GenericXmlApplicationContext("classpath:appCTX.xml");
		Person p1 = ctx.getBean("person1",Person.class);
		System.out.println("이름 :"+p1.getName());
		System.out.println("취미 :"+p1.getHobbies());

		Person p2 = ctx.getBean("person2",Person.class);
		System.out.println("이름"+p2.getName());
		System.out.println("취미"+p2.getHobbies());
		
		ctx.close();
	}

}
