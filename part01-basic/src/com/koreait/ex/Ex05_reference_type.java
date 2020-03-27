package com.koreait.ex;

public class Ex05_reference_type {

	public static void main(String[] args) {
		
		/*
		 * 참조 자료형 (reference type)
		 * - 값이 저장된 주소(참조)를 저장한다.
		 * - 기본 자료형이 아닌 모든 자료형은 참조 자료형이다.
		 * 
		 * 1. 문자열
		 *  1) String
		 *     (1) 문자열이 저장된 참조(주소)값을 저장한다.
		 *     (2) 기본 자료형처럼 선언해서 초기화 할 수 있다.
		 *     (3) 사용 방법
		 *        - String str1 = "Hello";  // 마치 기본 자료형처럼 사용
		 *        - String str2 = new String("Hello");  // 실제 대부분의 참조 자료형 사용 방법
		 *     (4) 참조 자료형의 초기화는 일반적으로 null 값이다.
		 */
		
		String str1 = "Hello";
		String str2 = new String("Hello");
		// String str3 = 0;  // 에러
		String str3 = null;  // null : 0번지 (0x00000000) - 아무 것도 가리키고 있지 않다.
		
		System.out.println(str1);
		System.out.println(str2);  // str1 과 같은 str2 인가? (내용은 Hello 로 같고, Hello 가 저장된 참조(주소)값이 다르다.)
		System.out.println(str3);

	}

}