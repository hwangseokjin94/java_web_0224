package com.koreait.upcasting;

//부모는 (슈퍼)
class Product {
	public void info() {
		System.out.println("Product");
	}
}

//자식-1
class Computer extends Product {
	//method Override :부모의 메소드를 자식이 다시만드는것
	@Override
	public void info() {
		System.out.println("Computer");
	}
}

class TV extends Product{
	@Override
	public void info() {
		System.out.println("TV");
	}
}
public class Ex01_product {
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
		
		products[2] = new Product(); //현실세계에서 존재하면 안되는 코드
		
		for(Product product : products) {
			if(product != null){
				product.info(); //같은코드 +다른동작 (다형성)
			}
		}
		
	}
}
















