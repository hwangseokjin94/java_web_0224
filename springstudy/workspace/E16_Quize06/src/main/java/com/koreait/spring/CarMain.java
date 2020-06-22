package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarMain {

	public static void main(String[] args) {
	 AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCTX.xml");
	 
	 Car mcar = ctx.getBean("myCar",Car.class);
	 
	 System.out.println("모델 : "+mcar.getModel());
	 System.out.println("연료 : "+mcar.getEngine().getFuelType());
	 System.out.println("배기량 : "+mcar.getEngine().getCc());
	 System.out.println("마력 : "+mcar.getEngine().getHp());
	 System.out.println("연비 : "+mcar.getEngine().getFuelEfficiency());
			 
	 ctx.close();
	 

	}

}
