package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		String resourceLocations ="classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		
		Person person = ctx.getBean("person1",Person.class);
		person.personInfo();
		
		BMICalculator bmi = ctx.getBean("bmi",BMICalculator.class);
		bmi.fn_bmi();
	
		ctx.close();
	}

}
