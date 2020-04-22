package com.koreait.ex2;

public class Person {

	// Field
	String name;
	int age;  // 성별 식별번호 1,2,5,6 : 1900년대,  3,4,7,8 : 2000년대
	String sn;  // 주민등록번호 (하이픈 포함)
	char gender;  // 성별 식별번호 1,3,5,7 : 남,  2,4,6,8 : 여
	boolean isKorean;  // 성별 식별번호 1~4 : 한국인, 5~8 : 외국인
	
	// Constructor
	Person(String _name, String _sn) {
		name = _name;
		sn = _sn;
		isKorean = sn.charAt(7) <= '4';
		gender = sn.charAt(7) % 2 == 0 ? '여' : '남';
		switch (sn.charAt(7)) {
		case '1': case '2': case '5': case '6':
			age = 2020 - (1900 + Integer.parseInt(sn.substring(0, 2)));  // 0번 인덱스 이상, 2번 인덱스 미만 (0번 인덱스부터 2글자)
			break;
		default:
			age = 2020 - (2000 + Integer.parseInt(sn.substring(0, 2)));
		}
	}
	
	// Method
	void printPerson() {
		System.out.println("이름 = " + name);
		System.out.println("주민등록번호 = " + sn.substring(0, 8) + "******");
		System.out.println("성별 = " + gender);
		System.out.println(isKorean ? "한국인" : "외국인");
		System.out.println("나이 = " + age + "살");
	}
	
}
