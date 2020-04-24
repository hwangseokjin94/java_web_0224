package com.koreait.ex1;

// 데이터클래스 Circle
class Circle {
	
	// Field
	int xPos;
	int yPos;
	double radius;
	
	// Constructor
	Circle() {
		// xPos = 0;  // 이미 되어 있으므로 생략 가능
		// yPos = 0;  // 이미 되어 있으므로 생략 가능
		radius = 1;
	}
	Circle(double r) {
		radius = r;
	}
	Circle(int x, int y, double r) {
		xPos = x;
		yPos = y;
		radius = r;
	}
	
	// Method
	double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	void printCircle() {
		System.out.println("중심좌표 : [" + xPos + ", " + yPos + "]");
		System.out.println("반지름 : " + radius + ", 크기 : " + calcArea());
	}
	
}

public class Ex04_Circle {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle();  // 중심좌표 [0, 0], 반지름 1
		Circle circle2 = new Circle(1.5);  // 중심좌표 [0, 0], 반지름 1.5
		Circle circle3 = new Circle(1, 2, 1.5);  // 중심좌표 [1, 2], 반지름 1.5
		
		circle1.printCircle();  // 중심좌표, 반지름, 크기
		circle2.printCircle();
		circle3.printCircle();

	}

}
