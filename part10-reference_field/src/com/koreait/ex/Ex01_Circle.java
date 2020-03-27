package com.koreait.ex;

// 데이터클래스 Coordinate
class Coordinate {
	
	// Field
	int xPos;
	int yPos;
	
	// Constructor
	Coordinate() {
		// this.xPos = 1;
		// this.yPos = 1;
		this(1, 1);
	}
	Coordinate(Coordinate coor) {
		// this.xPos = coor.xPos;
		// this.yPos = coor.yPos;
		this(coor.xPos, coor.yPos);
	}
	Coordinate(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	// Method
	void printCoordinate() {
		System.out.println("좌표 : [" + xPos + ", " + yPos + "]");
	}
	
}

// 데이터클래스 Circle
class Circle {
	
	// Field
	Coordinate center;  // 참조변수 (reference field) 초기화 null
	double radius;
	
	// Constructor
	Circle() {
		this(1, 1, 1);  // xPos, yPos, radius
	}
	Circle(double radius) {
		this(1, 1, radius);
	}
	Circle(int xPos, int yPos, double radius) {
		
		// center.xPos = xPos;  // center 는 null 이기 때문에 사용 불가.
		// center.yPos = yPos;  // center 는 null 이기 때문에 사용 불가.
		
		// new Coordinate 을 통해서 center 를 생성해야 한다.
		
		this.center = new Coordinate(xPos, yPos);
		this.radius = radius;
		
	}
	
	// Method
	double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	void printCircle() {
		System.out.print("중심");
		center.printCoordinate();
		System.out.println("반지름 : " + radius + ", 크기 : " + calcArea());
	}
	
}

public class Ex01_Circle {

	public static void main(String[] args) {
		
		Coordinate coor1 = new Coordinate(5, 5);
		Coordinate coor2 = new Coordinate(coor1);  // 생성자 작업
		coor1.printCoordinate();
		coor2.printCoordinate();
		
		Circle circle1 = new Circle();
		Circle circle2 = new Circle(1.5);
		Circle circle3 = new Circle(2, 3, 1.5);
		circle1.printCircle();
		circle2.printCircle();
		circle3.printCircle();

	}

}
