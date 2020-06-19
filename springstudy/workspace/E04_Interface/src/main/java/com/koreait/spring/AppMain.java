package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		
		String reourceLocations = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(reourceLocations);
	
		//인터페이스 타입으로 bean타입을 지정하면
		// main을 바꿀 일이 없다.
		
		App app = ctx.getBean("app",App.class);
		app.play();
		
		ctx.close();
	}
}
