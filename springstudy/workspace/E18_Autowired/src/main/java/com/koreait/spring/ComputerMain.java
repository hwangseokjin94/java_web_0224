package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ComputerMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCTX.xml");
		Computer computer = ctx.getBean("com",Computer.class);
		computer.playGame();
		computer.devApp();
		computer.volumeUp();
		computer.volumeDown();
		ctx.close();
	}
	
	
}
