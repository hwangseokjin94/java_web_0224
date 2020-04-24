package com.koreait.ex2;

// 실행은 메인 클래스에서 한다.

public class ComputerMain {

	public static void main(String[] args) {
		
		Computer myCom = new Computer();
		
		myCom.model = "GRAM";
		myCom.manufacturer = "LG";
		myCom.price = 200;
		
		System.out.println("모델 = " + myCom.model);
		System.out.println("제조사 = " + myCom.manufacturer);
		System.out.println("가격 = " + myCom.price);

	}

}
