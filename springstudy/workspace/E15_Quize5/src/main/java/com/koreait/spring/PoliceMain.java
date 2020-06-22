package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PoliceMain {

	public static void main(String[] args) {
		
		String resourceLocations = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		Police p = ctx.getBean("cop", Police.class);
		System.out.println("이름: " + p.getName());
		System.out.println("부서명: " + p.getDeptInfo().get("deptname"));
		System.out.println("부서위치: " + p.getDeptInfo().get("deptloc"));
		System.out.println("권총: " + p.getPistol().getModel());
		System.out.println("현재총알수: " + p.getPistol().getBullet() + "발");
		
		ctx.close();

	}

}
