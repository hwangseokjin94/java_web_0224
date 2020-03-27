package com.koreait.ex2;

public class Rect {
	
	// Field
	int width;
	int height;
	boolean isSquare;
	
	// Constructor
	Rect() {
		width = height = 1;
		isSquare = true;
	}
	Rect(int n) {
		width = height = n;
		isSquare = true;
	}
	Rect(int w, int h) {
		width = w;
		height = h;
		isSquare = (w == h);
	}
	
	// Method
	int calcArea() {
		return width * height;
	}
	void printRect() {
		System.out.println("너비 : " + width + ", 높이 : " + height);
		System.out.println("크기 : " + calcArea());
		System.out.println(isSquare ? "정사각형" : "직사각형");
	}
	
}
