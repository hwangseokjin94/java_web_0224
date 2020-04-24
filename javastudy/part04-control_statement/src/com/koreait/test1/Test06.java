package com.koreait.test1;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		// Test06.java
//		사용자로부터 임의의 문자를 하나 입력 받아 
//		"대문자", "소문자", "아라비아 숫자", "일반 문자" 구분해서 출력하기

		
		Scanner sc =new Scanner(System.in);
		System.out.println("문자를 입력하세요");
		char ch = sc.next().charAt(0);
		if(ch >='A' && ch <='Z') {
			System.out.println(ch+"는 대문자");
		}else if (ch >= 'a' && ch <='z') {
			System.out.println(ch+"는 소문자");			
		}else if (ch >= '0' && ch <='9') {
			System.out.println(ch+"는 아라비아숫자");		
		}else {
			System.out.println(ch+"는 일반문자");		
		}
		sc.close();
	}

}
