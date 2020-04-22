package com.koreait.ex;




class Coordninate {
	int xPos ; 
	int yPos;
	
	 Coordninate(int xPos , int yPos) {
		 this.xPos = xPos ;
		 this.yPos =yPos;
	
	}
	 
	 
	 void printCoordinate() {
		System.out.println( "X좌표"+xPos +"Y좌표"+yPos); 
	 }
	 
}

class Circle extends Coordninate{
	double radius;
	Circle (double radius , int xPos , int yPos){
		super(xPos,yPos);
		this.radius = radius;
	}
	
	double calcArea() {
		return Math.PI*Math.pow(radius, 2);
		
	}
	
	void printCircle() {
		printCoordinate();
		System.out.println("반지름 : "+radius +"크기"+calcArea());
	}
	
	
	
}
public class Ex05_has_a {

	public static void main(String[] args) {
		Circle circle = new Circle(1.5, 2, 3);
		circle.printCircle();

	}

}
