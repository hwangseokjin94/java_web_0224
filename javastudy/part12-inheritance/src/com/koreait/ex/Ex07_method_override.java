package com.koreait.ex;

class Pizza {

	String dough;
	int cheese;

	Pizza(String dough, int cheese) {
		this.dough = dough;
		this.cheese = cheese;
	}

	void printPizza() {
		System.out.println(" 도우  :" + dough);
		System.out.println("치즈 함량 : " + cheese);
	}

}

class BulgogiPizza extends Pizza {
	String bulgogi;

	public BulgogiPizza(String bulgogi, String dough, int cheese) {
		super(dough, cheese);
		this.bulgogi = bulgogi;

	}

	@Override
	void printPizza() {

		//System.out.println(" 도우  :" + dough);
		//System.out.println("치즈 함량 : " + cheese);
		super.printPizza();//Pizza 클래스의 printPizza()메소드
		System.out.println("불고기 원산지 : " + bulgogi);
	}
}

public class Ex07_method_override {
	public static void main(String[] args) {
		
		BulgogiPizza pizza = new BulgogiPizza("국내산", "씬", 100);
		pizza.printPizza();
		
	}
}
