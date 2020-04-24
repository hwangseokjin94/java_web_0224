package com.koreait.ex1;

// 데이터 클래스 Circle
class Circle {
	
	// Field
	double radius;
	String name;
	
	// Method
	void setCircle(String n, double r) {
		name = n;
		radius = r;
	}
	double calcArea() {
		// 크기를 반환
		return Math.PI * Math.pow(radius, 2);
	}
	void printCircle() {
		System.out.println("이름 = " + name);
		System.out.println("반지름 = " + radius);
		System.out.println("크기 = " + calcArea());
	}
	
}

public class Ex05_Circle {

	public static void main(String[] args) {
		
		Circle c = new Circle();
		
		c.setCircle("맨홀", 15.5);
		c.printCircle();
		
	}
	
}
