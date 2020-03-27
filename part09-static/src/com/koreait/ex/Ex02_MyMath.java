package com.koreait.ex;

// 데이터클래스 MyMath
class MyMath {
	
	// Field
	final static double PI = 3.141592;  // static final double PI = 3.141592; 동일
	
	
	// static 메소드 선정 기준
	// non-static 필드(인스턴스 필드)를 사용하지 않는 메소드
	
	
	// Method
	static int add(int a, int b) { return a + b; }
	static double add(double a, double b) { return a + b; }
	static double pow(double a, double b) {
		// a의 b제곱 리턴
		double result = 1;
		for (int i = 0; i < b; i++) {  // b만큼 반복
			result *= a;
		}
		return result;
	}
	
}

public class Ex02_MyMath {

	public static void main(String[] args) {
		
		// new MyMath() 없이 사용하는 static 멤버(필드, 메소드)
		
		System.out.println("MyMath PI : " + MyMath.PI);
		System.out.println(MyMath.add(1, 2));
		System.out.println(MyMath.add(1.5, 2.4));
		System.out.println(MyMath.pow(2, 3));
		
	}

}
