package com.koreait.ex1;

import java.util.Date;


// java.util.Date : 일반 자바 날짜
// java.sql.Date : 데이터베이스에 저장하는 날짜


// 데이터 클래스 User
class User {
	
	// Field
	String userId;
	String userPw;
	String userName;
	Date registerDate;
	
	// Method
	// Field 를 사용하는 함수 (입력, 출력, 저장, 변경 등)
	
	// 1. 필드 값을 저장하는 메소드
	void setUser(String id, String pw, String name) {
		userId = id;
		userPw = pw;
		userName = name;
		registerDate = new Date();
	}
	
	// 2. 필드 값을 출력하는 메소드
	void printUser() {
		System.out.println("아이디 = " + userId);
		System.out.println("비밀번호 = " + userPw);
		System.out.println("이름 = " + userName);
		System.out.println("가입일 = " + registerDate);
	}
	
}

// 메인 클래스
public class Ex04_User {

	public static void main(String[] args) {
		
		User user1 = new User();
		user1.setUser("admin", "123456", "관리자");
		user1.printUser();
		
		User user2 = new User();
		user2.setUser("niceguy", "654321", "김핸섬");
		user2.printUser();

	}

}
