package com.koreait.ex;

// int c = 300;  // 불가능 (모든 코드는 클래스 내부에 작성한다.)

public class Ex06_variable {

	int b = 200;
	
	public static void main(String[] args) {
		
		/*
		 * 변수 (variable)
		 *  1. 기본 자료형과 참조 자료형으로 구분한다.
		 *  2. 변수명
		 *     1) 숫자, 한글, 영문, 특수문자(_)를 혼합해서 사용할 수 있다.
		 *     2) 한글을 변수명으로 쓰는 개발자는 없다.
		 *     3) 공백 문자를 사용할 수 없다.
		 *     4) 숫자로 시작할 수 없다.
		 *     5) camel case 규칙을 따른다.
		 *        - 첫 글자는 소문자로 한다.
		 *        - 이후 단어의 첫 글자만 대문자로 한다.
		 *        - MyAge (X), myAge (O),  ma (X)
		 *     6) 변수명이 길어지는 것에 부담가지지 말자. (자동완성이 있다.)
		 *  3. 변수는 원하는 위치에서 선언할 수 있다.
		 *  4. 스코프(범위)
		 *     1) 지역 변수 : 코드 블록({})내에서 선언하고 사용하는 변수
		 *     2) 전역 변수 : 모든 지역에서 사용하는 변수
		 */
		
		int a = 100;  // warning (사용하지 않는 변수를 선언했기 때문에 경고, 실행은 잘 된다.)
		
		// System.out.println(a);  작성하면 warning 은 사라진다.
		
	}

}
