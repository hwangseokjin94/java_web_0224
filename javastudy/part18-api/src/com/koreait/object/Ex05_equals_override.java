package com.koreait.object;

class Rect {
	// Field
	private int width;
	private int height;

	// Constructor
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;

	}

	@Override
	public String toString() {
		String message = "두변의 길이가 [" + width + ", " + height + "]인 사각형";
		return message;
	}

	// 동등비교 조건
	// 1. 너비 == 너비 and 높이 ==높이
	// 2. 너비 == 높이 and 높이 ==너비
	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) {// 두 객체의 주소가 같다.
			return true;

		}
		if (anObject instanceof Rect) {
			Rect obj = (Rect) anObject;
			if (width == obj.width && height == obj.height) {
				return true;
			} else if (width == obj.height && height == obj.width) {
				return true;
			} else {
				return false;
			}
		}
		return false; // anObject이 Rect가 아니다.
	}

}

public class Ex05_equals_override {
	public static void main(String[] args) {
		Rect nemo1 = new Rect(2, 3);
		Rect nemo2 = new Rect(3, 2);
		
		System.out.println(nemo1);
		System.out.println(nemo2);

		if(nemo1.equals(nemo2)) {
			System.out.println("같은 사각형이다.");
		}else {
			System.out.println("다른 사각형이다.");
		}
	}
}
