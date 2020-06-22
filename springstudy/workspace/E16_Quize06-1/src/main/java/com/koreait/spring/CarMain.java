package com.koreait.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class CarMain {

	public static void main(String[] args) {
	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoCTX.class);
	Car car = ctx.getBean("myCar",Car.class);
	System.out.println(car.getModel());
	System.out.println(car.getEngine().getFuelType());
	System.out.println(car.getEngine().getCc());
	System.out.println(car.getEngine().getHp());
	System.out.println(car.getEngine().getFuelEfficiency());

	ctx.close();
	}

}
