package com.koreait.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class PersonHandlerMain {

	public static void main(String[] args) {
	 AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoCTX.class);
	 PersonHandler handler1 =ctx.getBean("pInfo1",PersonHandler.class);
	 handler1.personInfo();
	 
	 PersonHandler handler2 =ctx.getBean("pInfo2",PersonHandler.class);
	 handler2.personInfo();
	 
	 PersonHandler handler3 =ctx.getBean("pInfo3",PersonHandler.class);
	 handler3.personInfo();
	 
	 ctx.close();
	}

}
