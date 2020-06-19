package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GugudanMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCTX.xml");
		Gugudan g = ctx.getBean("gugudan", Gugudan.class);
		g.gugudanInfo();
		ctx.close();
		
	}
	
}
