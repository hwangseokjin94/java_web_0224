package com.koreait.ex2;

public class Circle {
	
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
