package com.koreait.ex1;

// 데이터 클래스 Computer
class Computer {
	// 값 = 변수 = 필드
	String model;
	String manufacturer;
	int price;
}

// 메인 클래스 : main 메소드를 가지고 있다.
public class Ex01_Computer {

	public static void main(String[] args) {
		
		// 사용자 정의 타입 : Computer
		// 객체 : myCom
		
		// myCom 객체 생성 방법
		Computer myCom = new Computer();
		
		// myCom 객체의 필드 사용 방법
		// 객체.필드
		myCom.model = "GRAM";
		myCom.manufacturer = "LG";
		myCom.price = 200;
		
		// 확인
		System.out.println("모델 = " + myCom.model);
		System.out.println("제조사 = " + myCom.manufacturer);
		System.out.println("가격 = " + myCom.price);
		
	}

}
