package com.koreait.test;

/*Test07.java
		Coordinate 클래스	필드 : int x, y
		메소드 : Constructor, toString(), equals()
Circle 클래스		필드 : Coordinate center, double radius
		메소드 : Constructor, toString(), equals()

toString() : 중심좌표 [0, 0], 반지름 : 1.5
equals() : 중심좌표와 반지름이 모두 같으면 true, 아니면 false
 */
class Coordinate {
	int xPos, yPos;

	public Coordinate(int xPos, int yPos) {

		this.xPos = xPos;
		this.yPos = yPos;
	}

	@Override
	public String toString() {
		return "[" + xPos + "," + yPos + "]";

	}

	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) {
			return true;
		}
		if (anObject instanceof Coordinate) {
			Coordinate obj = (Coordinate) anObject;
			if (xPos == obj.xPos && yPos == obj.yPos)
				return true;
		}
		return false;
	}

}

class Circle {
	private Coordinate center;
	private double radius;

	public Circle(int xPos, int yPos, double radius) {
		this.center = new Coordinate(xPos, yPos);
		this.radius = radius;
	}

	public Circle(Coordinate center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	@Override
	public String toString() {
		//center.toString == center  (Ex02설명)
//		return "중심좌표"+center.toStirng+ "반지름 : " + radius;
		return "중심좌표"+center+ "반지름 : " + radius;
	}

	@Override
	public boolean equals(Object anObject) {
		//중심좌표 :Coordinate의 equals()호출
		if (this == anObject) {
			return true;
		}
		if (anObject instanceof Circle) {
			Circle obj = (Circle) anObject;
				return center.equals(obj.center) &&radius == obj.radius;
			}  
			return false;
		}

	}



public class Test07 {

	public static void main(String[] args) {
		//1.Circle(int xPos, int yPos, double radius)
		Circle circle1 = new Circle(2, 3, 1.5);
		
		//2.Circle(Coordinate center, double radius)
		
		Circle circle2 = new Circle(new Coordinate(2, 3), 1.5);

		System.out.println(circle1);
//		System.out.println(circle1.toString());

		System.out.println(circle2);
//		System.out.println(circle2.toString());

		if (circle1.equals(circle2)) {
			System.out.println("같은 원이다.");
		} else {
			System.out.println("같은 원이아니다.");
		}

	}

}
