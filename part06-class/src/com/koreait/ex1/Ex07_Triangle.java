package com.koreait.ex1;

// 데이터 클래스 Triangle
class Triangle {
	
	// Field
	int width;
	int height;
	
	// Method
	void setTriangle(int w, int h) {
		width = w;
		height = h;
	}
	/*
	double calcArea() {
		return (width * height) / 2.0;
	}
	int calcArea() {
		return (width * height) / 2;
	}
	// 메소드이름과 매개변수가 모두 같으면 오버로딩 할 수 없다.
	// 리턴 타입의 동일 유무는 오버로딩 판단 대상이 아니다.
	*/
	double calcArea() {
		return (width * height) / 2.0;
	}
	void printTriangle() {
		System.out.println("너비 = " + width);
		System.out.println("높이 = " + height);
		System.out.println("크기 = " + calcArea());
	}
	
}

public class Ex07_Triangle {

	public static void main(String[] args) {
		
		Triangle semo = new Triangle();
		
		semo.setTriangle(3, 5);
		semo.printTriangle();
		
	}

}
