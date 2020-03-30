package com.koreait.test;

import java.util.Calendar;

public class Test04 {

	public static void main(String[] args) {
		/*
		 * Test04.java 각자 기념하고 싶은 기념일을 이용해서 기념일부터 오늘까지 며칠이 지났는지 계산하시오. Calendar 클래스와
		 * getTimeInMillis() 메소드 활용
		 */
		
		
		//기념일
		Calendar anniversary = Calendar.getInstance();
		anniversary.set(2020,2,26);
       
		Calendar today = Calendar.getInstance();
		
      long elapseTime =today.getTimeInMillis()-anniversary.getTimeInMillis(); 
//밀리초 >초>분>시간>일
      long elapseDay = (elapseTime/1000)/(60*60*24);
      System.out.println(elapseDay);
	}

}
