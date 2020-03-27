package com.itkoreaex;

//인터페이스 (작업지시서)
interface Shape {

	double calcArea(); //자동으로 public abstract double calcArea ();처리된다.
	String getName();//자동으로 public abstract double String getName();처리된다.

}
//구현 클래스 -1(작업지시서를 보고 만든 클래스 )
class Rect implements Shape {
	private int width;
	private int height;

	public Rect(int width, int height) {
		super();// Shape 의 디폴트 생성자.
		this.width = width;
		this.height = height;
	}

	@Override
	public double calcArea() {
		return width * height;
	}

	@Override
	public String getName() {
		return "사각형";
	}
}
//구현클래스 -2
class Circle implements Shape {
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return Math.pow(radius, 2) * Math.PI;

	}

	@Override
	public String getName() {
		return "원";
	}

}
//구현 클래스-3
class Triangel implements Shape {
	private int width;
	private int height;

	public Triangel(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double calcArea() {

		return width * height / 2.0;

	}

	@Override
	public String getName() {
		return "삼각형";
	}

}

public class Ex01_Shape {

	public static void main(String[] args) {
		// Rect Circle Triangle을 모두저장할수있는 타입은 Shape
		Shape[] shapeList = new Shape[3];
		// 업캐스팅
		shapeList[0] = new Rect(2, 1);
		shapeList[1] = new Circle(1.5);
		shapeList[2] = new Triangel(3, 5);

		// 다형성
		for (Shape shape : shapeList) {
			System.out.println(shape.getName() + "의 크기 :" + shape.calcArea());
		}

	}

}
