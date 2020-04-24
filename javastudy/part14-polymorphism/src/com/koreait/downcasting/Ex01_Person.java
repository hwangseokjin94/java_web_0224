package com.koreait.downcasting;

class Person {
	
	public void eat(String food) {
		System.out.println(food + " 먹는다.");
	}
	public void sleep() {
		System.out.println("잔다.");
	}
	public void goToToilet() {
		System.out.println("볼일을 본다.");
	}
	
	
}
class Student extends Person{
	public void study() {
		System.out.println("공부한다.");
	}
}

class Worker extends Person{
	public void work() {
		System.out.println("일한다.");
	}
}


public class Ex01_Person {

	public static void main(String[] args) {
		 Person p1 = new Student(); //업캐스팅
		 p1.eat("밥");
		 p1.sleep();
		 p1.goToToilet();
//		 p1.study();//? 호출 불가(p1이 Person타입이므로 Person의 메소드만 호출할수 있다.)
		 //부모타입 -> 자식타입 : 다운캐스팅 ,강제형변환으로 진행
		 //자식 (Student)만 가지고 있는 메소드 호출이 필요한 경우
		 
		 ((Student)p1).study();//다운캐스팅
		 
		 Person p2 = new Worker(); // 업캐스팅
		 p2.eat("고기");
		 p2.sleep();
		 p2.goToToilet();
		 ((Worker)p2).work(); //다운캐스팅
		 
		 //잘못된 다운캐스팅
		 //개발자의 실수
		Person p3 = new Student(); //업캐스팅
//		((Worker)p3).work(); //잘못된다운캐스팅 - > ClassCastException 발생
		
		//예외발생을 회피하기 위해 확인 후 캐스팅을 처리한다.
		//p3이 Worker 타입이면 캐스팅을 하겠다. 
		if(p3 instanceof Worker) { //p3이 Worker의 인스텐스인
			((Worker)p3).work();
		}
		//캐스팅은 강력한 명령어이기때문에 에러가나거나 죽는다.
		 
		 
	}

}






