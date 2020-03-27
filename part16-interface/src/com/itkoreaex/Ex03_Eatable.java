package com.itkoreaex;

//인터 페이스명  :~할수있는 
interface Eatable {
	void eat();

	void caloireInfo();
}

//구현클래스 : 반드시 인터페이스의 모든 "추상메소드를"오버라이드를 해야한다.
class Apple implements Eatable {

	@Override
	public void eat() {
		System.out.println("아침에 먹는 사과가 좋다.");

	}

	@Override
	public void caloireInfo() {
		System.out.println("칼로리 : 100Kcal");

	}

}

public class Ex03_Eatable {

	public static void main(String[] args) {
		
		//Apple apple = new Apple(); 생초보....
		
		Eatable apple = new Apple();
		apple.eat();
		apple.caloireInfo();
	}
}