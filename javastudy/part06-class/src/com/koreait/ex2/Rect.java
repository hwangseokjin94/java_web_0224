package com.koreait.ex2;

public class Rect {

	// Field
	int width;  // 너비
	int height;  // 높이
	boolean isSquare;  // 정사각형 유무
	
	// Method
	void setRect(int w, int h) {
		width = w;
		height = h;
		isSquare = (w == h);  // isSquare = (width == height);
	}
	void setRect(int n) {
		width = n;
		height = n;
		isSquare = true;
	}
	int calcArea() {
		return width * height;
	}
	void printRect() {
		System.out.println("너비 = " + width);
		System.out.println("높이 = " + height);
		System.out.println("크기 = " + calcArea());
		System.out.println(isSquare ? "정사각형" : "직사각형");
	}
	
}
