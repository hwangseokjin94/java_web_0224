package com.koreait.ex;

class Parent{
	
	int parentNum;
	//메소드
	void parentMethod() {
		System.out.println("parentMethod() 호출한다;."+parentNum);
	}
}

class Child extends Parent{
	
	int childNum;
	void childMethod() {
		System.out.println("childMethod()을 호출한다,"+childNum);
	}
}

//자식은 부모를 확장한 클래스이므로 자식은 부모의 필드및 메소드를사용할수있다.

public class Ex01_inheritance {

	public static void main(String[] args) {

		//상속확인은 자식클래스
		Child child = new Child();
		
		child.parentNum =100;
		child.childNum = 10 ;
		
		child.parentMethod();
		child.childMethod();

	}

}
