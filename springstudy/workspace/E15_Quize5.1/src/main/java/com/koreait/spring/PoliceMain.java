package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PoliceMain {

	public static void main(String[] args) {

		AbstractApplicationContext ctx =  new GenericXmlApplicationContext("classpath:appCTX.xml");
		Police p =ctx.getBean("policeInfo",Police.class);
		p.policeMainInfo();
		ctx.close();
		


	}

}
