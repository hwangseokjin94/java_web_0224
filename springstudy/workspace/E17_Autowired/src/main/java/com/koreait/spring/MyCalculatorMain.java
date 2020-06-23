package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyCalculatorMain {
	public static void main(String[] args) {
		String resourecLoactions = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourecLoactions);
		MyCalculator MyCalc = ctx.getBean("MyCalc",MyCalculator.class);
		MyCalc.alarm();
		//MyCalc.getCalculator().addition(1,2);
		MyCalc.addition(3,6);
		ctx.close();
	}
}
