package com.koreait.object;
class Car{
	private String model;
	private int price ;
	public Car(String model, int price) {
	
		this.model = model;
		this.price = price;
	}
	
	//Constructor
	
}
public class Ex04_equals {

	public static void main(String[] args) {
		Car car1 = new Car("bmw",5000);
		Car car2 = new Car("bmw",5000);

		//equals() 메소드의 기본동작 (Object 클래스의 equlas()메소드의 동작)
		//두 객체(인스턴스)의 참조(주소를 비교)
		if(car1.equals(car2)) {
			System.out.println("같은차이다.");
		}else {
			System.out.println("다른차이다");
		}
		//두 자동차의 내용은같지만 주소는 다르기때문이다.
		
		//object 클래스의  equals()메소드를 오버라이드(다시만들기)하면
		//객체의 동등 비교를 할 수있다.
		
	}

}
