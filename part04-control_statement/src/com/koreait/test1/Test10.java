package com.koreait.test1;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
	/*
		Test10.java - switch 문
		월을 입력 받아 일을 출력하기
		단, 윤년은 고려하지 않음 (2월은 28일에 끝난다는 의미)
		실행 예)
		월 입력 >> 10
		10월은 31일까지 있습니다.
	 * */
		System.out.println("월입력>>");
	Scanner sc = new Scanner(System.in);
		int month =sc.nextInt(); 
	
		
		if(month <1||month>12) {
			System.out.println("없는월이다");
			System.exit(0);//정상종료
			System.exit(1);//비정상종료(0이외의 값 전달)
		}
		
		int day=0;
		switch(month) { 
		
		case 2 :  day=28; break;
		case 4 : case 6 :case 9 :case 11 :case 30 : day=28; break;
		default: day =31;
		}
			System.out.println(month+"월은"+day+"일까지 있습니다");
					
		sc.close();
		}
	}


