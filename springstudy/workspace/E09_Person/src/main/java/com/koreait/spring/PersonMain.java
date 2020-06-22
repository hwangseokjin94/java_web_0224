package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {

		String resourceLocation1 = "classpath:appCTX1.xml";
		String resourceLocation2 = "classpath:appCTX2.xml";
		AbstractApplicationContext  ctx = new GenericXmlApplicationContext(resourceLocation1 , resourceLocation2);
		Person person = ctx.getBean("p",Person.class);
		person.personInfo();
		

	}

}
