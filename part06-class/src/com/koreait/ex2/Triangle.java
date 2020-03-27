package com.koreait.ex2;

public class Triangle {
	
	// Field
	int width;
	int height;
	
	// Method
	void setTriangle(int w, int h) {
		width = w;
		height = h;
	}
	double calcArea() {
		return (width * height) / 2.0;
	}
	void printTriangle() {
		System.out.println("너비 = " + width);
		System.out.println("높이 = " + height);
		System.out.println("크기 = " + calcArea());
	}
	
}
