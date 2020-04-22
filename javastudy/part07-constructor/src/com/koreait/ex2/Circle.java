package com.koreait.ex2;

public class Circle {
	
	// Field
	int xPos;
	int yPos;
	double radius;
	
	// Constructor
	Circle() {
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
