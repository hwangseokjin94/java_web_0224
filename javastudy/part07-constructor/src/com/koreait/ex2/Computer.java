package com.koreait.ex2;

public class Computer {
	
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
