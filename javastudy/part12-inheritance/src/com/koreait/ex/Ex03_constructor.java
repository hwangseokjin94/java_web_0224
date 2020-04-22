package com.koreait.ex;

class Father {
	int parentNum;
	Father(){
		System.out.println("아빠가 태어났다");
	}
}
class Son  extends Father{
	Son(){
		//super : 부모클래스를 의미
		//1. super.멤버 :super.필드   super.메소드();
		//2. super():부모클래스의 생성자 호출

		super();//생략가능
		System.out.println("아들이 태어났다.");
	}
}

///자식클래스으의 생성자는 부모클래스의 생성자를 먼저 호출한다.
//자식이만들여지려면 반드시 부모가 필요함




public class Ex03_constructor {

	public static void main(String[] args) {
		@SuppressWarnings("unsed")//사용안하는것이다
		Son son = new Son();
		

	}

}
