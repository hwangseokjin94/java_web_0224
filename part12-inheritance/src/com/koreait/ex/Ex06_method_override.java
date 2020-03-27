package com.koreait.ex;

//부모(슈퍼)
class Espresso {
	String beanOrigin;
	int water;

	Espresso(String beanOrigin, int water) {
		this.beanOrigin = beanOrigin;
		this.water = water;
	}

	void taste() {
		System.out.println("쓰다.");
	}

}

//자식
class Latte extends Espresso {
	int milk;

	Latte(int milk, String beanOrigin, int water) {
		super(beanOrigin, water);
		this.milk = milk;

	}
	//오버라이드 하는 메소드는 @Override 애너테이션을 붙이는것이좋다.
	@Override
	void taste() {   //Espresso의 taste()를그대로 사용할수없어서 "메소드 오버라이드(다시만들기)"를 진행		
		System.out.println("부드럽다.");
	}
}

public class Ex06_method_override {
	public static void main(String[] args) {
		Latte latee = new Latte(200, "인도네시아", 50);
		latee.taste();
	}
}
