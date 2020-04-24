package com.koreait.ex1;

// 데이터 클래스 Rect
class Rect {
	
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

public class Ex05_Rect {

	public static void main(String[] args) {
		
		Rect nemo1 = new Rect();  // 너비 1, 높이 1, 정사각형
		Rect nemo2 = new Rect(2);  // 너비 2, 높이 2, 정사각형
		Rect nemo3 = new Rect(2, 3);  // 너비 2, 높이 3, 직사각형
		
		nemo1.printRect();  // 너비, 높이, 크기, 정사각형/직사각형
		nemo2.printRect();
		nemo3.printRect();

	}

}
