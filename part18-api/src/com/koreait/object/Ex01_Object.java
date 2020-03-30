package com.koreait.object;


class Computer {
	private String model; 
	private int price;
	
	public Computer (String model , int price) {
		this.model = model;
		this.price = price ; 
	}
	
	
	public void printComputer() {
		System.out.println( " 제품명 : "+model + " 가격 : "+price);
	}
	
	
}

public class Ex01_Object {

	public static void main(String[] args) {
	
		/*Object 모든 클래스의 부모
		 * Object 타입 : 모든 객체 변수를 저장할수 있는 타입
		 * 
		 * 1.변수 저장
		*/
		//1. 변수저장
		Object obj = new Object();
		obj = 10 ;
		System.out.println(obj);
		
		obj = 1.5 ;		
		System.out.println(obj);
		
		Computer myCom = new Computer("GRAM", 200);
		myCom.printComputer();
		
		Object yourCom = new Computer("SENS", 200); // yourCom의 view는 object(Object의 메소드만 호출할수있다.)
		//자식타입인 Computer의 메소드를 호출하려면 , 자식타입으로 형변환(다운캐스팅)이 필요하다.
		((Computer)yourCom).printComputer();
		
		
		
		
		
		
		
		
		
		
	}

}
