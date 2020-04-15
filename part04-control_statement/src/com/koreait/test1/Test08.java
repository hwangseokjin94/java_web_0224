package com.koreait.test1;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
//		Test08.java - switch 문
//		섭씨/화씨 변환기
//		섭씨를 입력하면 변환된 화씨를 출력하고, 화씨를 입력하면 변환된 섭씨를 출력하기
//		화씨 = 섭씨 * 1.8 + 32
//		섭씨 = (화씨 - 32) / 1.8
//		실행 예)
//		입력할 온도의 종류를 선택하세요(섭씨 또는 화씨) >> 섭씨
//		섭씨 입력 >> 12.5
//		변환된 화씨는 54.5℉ 입니다.

		Scanner sc = new Scanner(System.in);
		 
		
		
		System.out.println("입력할 온도의 종류를 선택하세요(섭씨 또는 화씨) >>");
		String choice =sc.next();
		switch(choice) { 
		case "섭씨" :
			System.out.println("섭씨 입력입력>>>");
			double celsius = sc.nextDouble();
			double fahrenheit =celsius *1.8+31;
			System.out.println("변환된화씨는"+fahrenheit+"입니다.");
			break;
		case "화씨":
			System.out.println("썹씨 입력입력>>>");
			fahrenheit = sc.nextDouble();
			 celsius=(fahrenheit-32)/1.8;
			 System.out.println("변환된섭씨는"+celsius+"입니다.");
			 break;
		 default:
				 System.out.println("섭씨또는 화씨만 입력가능합니다.");
		}
		sc.close();
		}
		
}
		
		
	
	

//	if(q.equals("화씨")) {
////		  temp =(in-32)/1.8;  
//		}
//		
//		System.out.println("변환된화씨는"+temp+"입니다.");
//		
//	}

	
	
	
	

