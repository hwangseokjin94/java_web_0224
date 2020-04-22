package com.koreait.ex1;


// 한 자바파일에 클래스가 2개 이상인 경우에는
// 자바파일의 이름과 같은 이름의 클래스가 public 처리된다.


// 데이터 클래스 Person
class Person {
	// Field
	char gender;  // '\0' (널 문자 : 보이지 않는다.)
	int age;  // 0
	double height;  // 0.0
	String name;  // null (참조 자료형)
	boolean isAdult;  // false
}


// 메인 클래스
public class Ex03_Person {

	public static void main(String[] args) {
		
		Person p = new Person(); 
		
		System.out.println("성별 = " + p.gender);
		System.out.println("나이 = " + p.age);
		System.out.println("키 = " + p.height);
		System.out.println("이름 = " + p.name);
		System.out.println("성인유무 = " + p.isAdult);
		
	}

}
