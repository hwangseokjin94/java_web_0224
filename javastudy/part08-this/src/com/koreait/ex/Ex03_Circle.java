package com.koreait.ex;

// 데이터클래스 Circle
class Circle {
	
	// Field
	int xPos;
	int yPos;
	double radius;
	
	// Constructor
	Circle () {
		this(0, 0, 1);  // 다른 생성자 중에서 "파라미터가 3개" 인 생성자를 호출한다.
	}
	Circle (double radius) {
		this(0, 0, radius);  // 다른 생성자 중에서 "파라미터가 3개" 인 생성자를 호출한다.
	}
	Circle (int xPos, int yPos, double radius) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.radius = radius;
	}
	
	// Method
	double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	void printCircle() {
		System.out.print("중심좌표 : [" + xPos + ", " + yPos + "], ");
		System.out.println("반지름 : " + radius + ", 크기 : " + calcArea());
	}
	
}

public class Ex03_Circle {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle();
		Circle circle2 = new Circle(1.5);
		Circle circle3 = new Circle(2, 3, 1.5);
		
		circle1.printCircle();
		circle2.printCircle();
		circle3.printCircle();

	}

}
