package com.koreait.ex;

public class Ex02_literal {

	public static void main(String[] args) {
		
		// 1. 문자 표현 방식 (홑따옴표, 작은따옴표)
		// 한글과 영문에 모두 적용된다.
		System.out.println('A');
		System.out.println('한'); // c는 안 되고, java는 된다.
		
		// 2. 문자열 표현 방식 (쌍따옴표, 큰따옴표)
		System.out.println("Hello");
		
		// 3. 정수나 실수 표현 방식 (그냥 입력)
		System.out.println(100);
		System.out.println(3.141592);
		
		// 4. 논리값 표현 방식
		System.out.println(true);
		System.out.println(false);
		
		// 5. 이스케이프 문자
		// 1) \n : 줄바꿈
		// 2) \t : 탭
		// 3) \" : 쌍따옴표
		// 4) \' : 홑따옴표		

	}

}
