package com.koreait.ex2;

public class CircleMain {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle();  // 중심좌표 [0, 0], 반지름 1
		Circle circle2 = new Circle(1.5);  // 중심좌표 [0, 0], 반지름 1.5
		Circle circle3 = new Circle(1, 2, 1.5);  // 중심좌표 [1, 2], 반지름 1.5
		
		circle1.printCircle();  // 중심좌표, 반지름, 크기
		circle2.printCircle();
		circle3.printCircle();

	}

}
