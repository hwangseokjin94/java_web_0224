package com.koreaitex;

class Computer {
	private String model;
	private int price;

	public Computer(String model, int price) {
		this.model = model;
		this.price = price;
	}

	 void printComputer() {
		System.out.println("모델명 :" + model + "가격 : " + price);
	}

}// class computer

public class Ex02_Computer {
	public static void main(String[] args) {
//컴퓨터 클래스 외부이기때문에 프라이빗 필드는 접근이 불가능하고 퍼블릭 메소드 (생성자 포함)만 접근이가능
		Computer myCom= new Computer("GRAM", 200);
		myCom.printComputer();
		
		//private필드 직접 접근은제한된다.
//		myCom.model ="SENS";
//		myCom.price =300;
		
		
	}
}
