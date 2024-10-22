package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculatorMain {

	public static void main(String[] args) {
		
		String resourceLocations = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		//ctx가 xml을 통해 bean을 생성하려면 getBean()메소드를 사용한다.
		//getBean("<bean>태그의 id","class타입")
		MyCalculator myCalculator1 =ctx.getBean("myCalculator1",MyCalculator.class);
		 myCalculator1.addtion();
		 myCalculator1.substraction();
		 myCalculator1.multiplication();
		 myCalculator1.division();
		 
		 MyCalculator myCalculator2 =ctx.getBean("myCalculator2",MyCalculator.class);
		 myCalculator2.addtion();
		 myCalculator2.substraction();
		 myCalculator2.multiplication();
		 myCalculator2.division();
		 
		 ctx.close();
		 
	}

}
