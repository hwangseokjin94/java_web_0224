package com.koreait.etc;

import java.util.Calendar;
//import java.sql.Date;
import java.util.Date;
public class Ex06_Date {
		public static void main(String[] args) {
			//1.자바용 date : java.util.Date(java.util패키지에 저장된 Date
			//2 SQL용 Date :java.sql.Date(java.sql패키지에 저장된 Date
			//자바용 Date
			//Date now =new Date();
			//System.out.println("현재시간 : " +now);
			//Date now = new Date(System.currentTimeMillis());
			//System.out.println("현재시간 : " +now);
			//Calendar 를 통해 자바용 Date
			
			
			
			Calendar cal  = Calendar.getInstance();
			Date now = cal.getTime();
			System.out.println("현재시간 : " +now);
			
		}

}
