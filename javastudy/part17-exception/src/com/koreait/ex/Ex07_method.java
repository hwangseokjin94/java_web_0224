package com.koreait.ex;

public class Ex07_method {
	// static 메소드는
	// static 필드나 static 메소드를 호출할수있다.

	// 나누기 메소드 divide()
	public static void divide(int a, int b) {
		System.out.println("몫:" + (a / b));
		System.out.println("나머지:" + (a % b));
	}

	public static void main(String[] args) {
		// divide()메소드호출
		try {		
			divide(10, 3);
			divide(10, 0);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
