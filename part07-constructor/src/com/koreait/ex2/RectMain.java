package com.koreait.ex2;

public class RectMain {

	public static void main(String[] args) {
		
		Rect nemo1 = new Rect();  // 너비 1, 높이 1, 정사각형
		Rect nemo2 = new Rect(2);  // 너비 2, 높이 2, 정사각형
		Rect nemo3 = new Rect(2, 3);  // 너비 2, 높이 3, 직사각형
		
		nemo1.printRect();  // 너비, 높이, 크기, 정사각형/직사각형
		nemo2.printRect();
		nemo3.printRect();
		
	}

}
