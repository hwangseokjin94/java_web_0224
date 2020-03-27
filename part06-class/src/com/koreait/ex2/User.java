package com.koreait.ex2;

import java.util.Date;

public class User {
	
	// Field
	String userId;
	String userPw;
	String userName;
	Date registerDate;

	// Method
	void setUser(String id, String pw, String name) {
		userId = id;
		userPw = pw;
		userName = name;
		registerDate = new Date();
	}
	void printUser() {
		System.out.println("아이디 = " + userId);
		System.out.println("비밀번호 = " + userPw);
		System.out.println("이름 = " + userName);
		System.out.println("가입일 = " + registerDate);
	}
	
}
