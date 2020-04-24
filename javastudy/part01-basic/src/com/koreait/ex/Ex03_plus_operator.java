package com.koreait.ex;

public class Ex03_plus_operator {

	public static void main(String[] args) {
		
		// 1. 숫자끼리 + 연산자 : 산술 연산자
		System.out.println(1 + 1);
		System.out.println(1.5 + 2.5);
		System.out.println(1.5 + 2);
		
		// 2. 문자열이 포함된 + 연산자 : 연결 연산자
		// c 에서는 strcat 함수
		System.out.println("Hello " + "World");
		
		// 3. 출력 결과를 예상해보자.
		System.out.println(100 + "원");  // 100원
		System.out.println(100 + 100 + "원");  // 200원 
		System.out.println("$" + 100);  // $100
		System.out.println("$" + 100 + 100);  // $100100
		System.out.println("$" + (100 + 100));  // $200
		
	}

}
