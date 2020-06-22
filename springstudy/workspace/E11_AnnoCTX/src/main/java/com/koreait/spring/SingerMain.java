package com.koreait.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SingerMain {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoCTX.class);
		
		Singer s = ctx.getBean("singer",Singer.class);
		s.singerInfo();
		ctx.close();
		
	}
}
