package com.koreait.ex1;

// 데이터 클래스 Rect
class Rect {
	
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

public class Ex06_Rect {

	public static void main(String[] args) {

		Rect nemo1 = new Rect();
		Rect nemo2 = new Rect();
		
		nemo1.setRect(4, 3);
		nemo2.setRect(5);
		
		nemo1.printRect();
		nemo2.printRect();
		
	}

}
