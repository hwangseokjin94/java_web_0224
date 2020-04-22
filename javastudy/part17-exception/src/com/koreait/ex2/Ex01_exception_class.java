package com.koreait.ex2;

class MyException extends Exception{
	//Constructor 
	public MyException(String message) {
		// 부모의 생성자호출
		super(message); // public Exception(String message){}호출
	}
}

public class Ex01_exception_class {

	public static void main(String[] args) {
		try {
			//myException 던지기
			throw new MyException("내가 만든 예외 메시지");
		}catch(Exception e) {
			System.out.println("MyException이 발생했다.");
			System.out.println("사용자 정의 예외 메시지  :  "+e.getMessage());
		} 

	}

}
