package com.koreait.ex3;

public class Ex01_RecursiveCall {

	// static 메소드 (클래스 메소드) 내에서는 
	// static 필드와 static 메소드만 호출할 수 있다.
	
	// Field
	static int count = 0;  // 몇 번 호출되었는지 카운트 할 목적
	
	// Method
	static void recursive() {
		System.out.println(++count + "번째 recursive()이 호출되었다.");
		if (count == 10) {
			return;  // recursive() 메소드 종료 (리턴이 void 인 경우, return; 문은 메소드를 종료하는 문으로 사용된다.)
		}
		recursive();  // recursive() 메소드 호출
	}
	
	public static void main(String[] args) {
		
		recursive();
		
	}
	
}
