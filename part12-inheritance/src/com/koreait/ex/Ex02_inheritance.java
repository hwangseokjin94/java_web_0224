package com.koreait.ex;

//상속관꼐의 대표적인상황.
//IS-a관계 전기차는 자동차이다.

//부모(슈퍼)
class Car{
	void drive() {
		System.out.println("차가달린다");
	}
}

class EV extends Car{
	void charging() {
		System.out.println("저기를 충전한다");
	}
}


public class Ex02_inheritance {

	public static void main(String[] args) {
		EV car = new EV();
		car.drive();
		car.charging();
		
		Car car2 = new Car();
		car2.drive();
		
	}

}
