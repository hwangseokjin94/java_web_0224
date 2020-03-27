package com.koreaitex;

//부모는 (슈퍼)
abstract class Product {//2.추상클래스가 된다.
	abstract public void info(); //1.본문이 없는 추상메소드를 추가하면
}

//자식-1
class Computer extends Product {

	@Override
	public void info() {    //3.추상클래스의 추상 메소드는 "반드시" 오버라이드 해야한다.
		System.out.println("Computer");
	}
}

class TV extends Product{
	@Override
	public void info() {
		System.out.println("TV");
	}
}
public class Ex01_Product {
	public static void main(String[] args) {
		//여기는 매장이다.
		//computer 10대 Tv 5대
		Computer[] computers = new Computer[10];
		TV[] tvs =new TV[5];
		//만약 100개 제품을 관리하기 위해서 100개의 배열을 관리하는 것은 :"어렵다."

		//해결책으로 "업캐스팅"을 활용한다.
		//부모(Produvt) 타입은 자식(Computer ,TV)을 저장할수있다. (자동 타입 변환)
		
		Product[] products = new Product[15];
		products[0] = new Computer(); // 업캐스팅
		products[1] = new TV();
		
//		products[2] = new Product();//추상클래스는 객체를 생성할수없다.
		for(Product product : products) {
			if(product != null){
				product.info(); //같은코드 +다른동작 (다형성)
			}
		}
		
	}
}




