package com.koreait.ex1;

// 데이터 클래스 Computer
class Computer {
	
	// Field
	String model;
	String manufacturer;
	int price;
	
	// Constructor
	Computer(String _model, String _manufacturer, int _price) {
		System.out.println("Computer 객체가 생성되었다.");
		model = _model;
		manufacturer = _manufacturer;
		price = _price;
	}
	
	// Method
	void printComputer() {
		System.out.println("모델 = " + model);
		System.out.println("제조사 = " + manufacturer);
		System.out.println("가격 = " + price);
	}
	
}

// 메인 클래스
public class Ex01_Computer {

	public static void main(String[] args) {
		
		// Computer 클래스를 이용한 myCom 객체 생성
		Computer myCom = new Computer("GRAM", "LG", 200);  // Computer() : 생성자, Computer 객체를 생성하는 메소드
		
		myCom.printComputer();

	}

}
